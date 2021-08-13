package com.github.AustinWagstaffWeber.CS3230Repo;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Data {
    // Class variables
    private String queryString = null;
    private String baseURL = "https://www.bungie.net/Platform";
    private String x_api_key = "a99fb2d4aa4e4dba825b260f9f03ece0";

    public JSONObject runItemManifestQuery(int hashval){
        ArrayList<String> queryResults = new ArrayList<String>();
        Connection connection = null;
        try {
          connection = DriverManager.getConnection("jdbc:sqlite::resource:world_sql_content_e0cb6a470d4cfbf3affd8ad44bb72df6.sqlite3");
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery("SELECT json FROM DestinyInventoryItemDefinition WHERE id = " + hashval);
          while (rs.next())
          {
              queryResults.add(rs.getString("json"));
          }
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (connection != null) connection.close();
            }
            catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }
        JSONObject obj = new JSONObject(queryResults.get(0));
        return obj;
    }

    public int getMemberType(String displayName){
        HttpResponse<JsonNode> response = Unirest.get(baseURL+"/Destiny2/SearchDestinyPlayer/-1/"+displayName+"/")
                .header("X-API-Key", x_api_key)
                .header("Cookie", "Q6dA7j3mn3WPBQVV6Vru5CbQXv0q+I9ddZfGro+PognXQwjW=v1tNlRgw__HGw; __cflb=0H28vP5GxS7vgVH4MZT6rB7QcDNQ8jpmWp1X52mpcLj; bungleanon=sv=BAAAAACfFAAAAAAAADx6MgIAAAAAAAAAAAAAAAAXE/EAcFzZCEAAAABeQoQbWTDHtunxaLytfJkE+hjZqL5NItUNJdgY45xVN/W3f8y2yqPgPuXgv5DmcpIB3YCNI/Fgid2BUTFWQkDY&cl=MC41Mjc5LjM2ODYyNTI0; bungled=8742384451902493658; bungledid=BxxFiekSsKJDobniRgy2Vq0XE/EAcFzZCAAA")
                .asJson();
        JSONArray obj = response.getBody().getObject().getJSONArray("Response");
        JSONObject val = obj.getJSONObject(0);
        return val.getInt("membershipType");
    }

    public String getMemberID(String displayName){
        HttpResponse<JsonNode> response = Unirest.get(baseURL+"/Destiny2/SearchDestinyPlayer/-1/"+displayName+"/")
                .header("X-API-Key", x_api_key)
                .header("Cookie", "Q6dA7j3mn3WPBQVV6Vru5CbQXv0q+I9ddZfGro+PognXQwjW=v1tNlRgw__HGw; __cflb=0H28vP5GxS7vgVH4MZT6rB7QcDNQ8jpmWp1X52mpcLj; bungleanon=sv=BAAAAACfFAAAAAAAADx6MgIAAAAAAAAAAAAAAAAXE/EAcFzZCEAAAABeQoQbWTDHtunxaLytfJkE+hjZqL5NItUNJdgY45xVN/W3f8y2yqPgPuXgv5DmcpIB3YCNI/Fgid2BUTFWQkDY&cl=MC41Mjc5LjM2ODYyNTI0; bungled=8742384451902493658; bungledid=BxxFiekSsKJDobniRgy2Vq0XE/EAcFzZCAAA")
                .asJson();
        JSONArray obj = response.getBody().getObject().getJSONArray("Response");
        JSONObject val = obj.getJSONObject(0);
        return "" + val.get("membershipId");
    }

    public String getCharacter(int index, int memberType,String membershipID){
        HttpResponse<JsonNode> response = Unirest.get(baseURL+"/Destiny2/"+memberType+"/Profile/"+membershipID+"/")
                .header("X-API-Key", x_api_key)
                .header("Cookie", "Q6dA7j3mn3WPBQVV6Vru5CbQXv0q+I9ddZfGro+PognXQwjW=v1tNlRgw__HGw; __cflb=0H28vP5GxS7vgVH4MZT6rB7QcDNQ8jpmWp1X52mpcLj; bungleanon=sv=BAAAAACfFAAAAAAAADx6MgIAAAAAAAAAAAAAAAAXE/EAcFzZCEAAAABeQoQbWTDHtunxaLytfJkE+hjZqL5NItUNJdgY45xVN/W3f8y2yqPgPuXgv5DmcpIB3YCNI/Fgid2BUTFWQkDY&cl=MC41Mjc5LjM2ODYyNTI0; bungled=8742384451902493658; bungledid=BxxFiekSsKJDobniRgy2Vq0XE/EAcFzZCAAA")
                .queryString("components","100")
                .asJson();
        JSONObject obj = response.getBody().getObject()
                .getJSONObject("Response")
                .getJSONObject("profile")
                .getJSONObject("data");
        JSONArray ar = (JSONArray) obj.get("characterIds");
        return "" + ar.get(index);
    }

    public JSONObject getCharacterItem(int index, int memberType, String memberID, String charID){
        HttpResponse<JsonNode> response = Unirest.get(baseURL+"/Destiny2/"+memberType+"/Profile/"+memberID+"/Character/"+charID+"/")
                .header("X-API-Key", x_api_key)
                .header("Cookie", "Q6dA7j3mn3WPBQVV6Vru5CbQXv0q+I9ddZfGro+PognXQwjW=v1tNlRgw__HGw; __cflb=0H28vP5GxS7vgVH4MZT6rB7QcDNQ8jpmWp1X52mpcLj; bungleanon=sv=BAAAAACfFAAAAAAAADx6MgIAAAAAAAAAAAAAAAAXE/EAcFzZCEAAAABeQoQbWTDHtunxaLytfJkE+hjZqL5NItUNJdgY45xVN/W3f8y2yqPgPuXgv5DmcpIB3YCNI/Fgid2BUTFWQkDY&cl=MC41Mjc5LjM2ODYyNTI0; bungled=8742384451902493658; bungledid=BxxFiekSsKJDobniRgy2Vq0XE/EAcFzZCAAA")
                .queryString("components","205")
                .asJson();
        JSONArray obj = response.getBody().getObject()
                .getJSONObject("Response")
                .getJSONObject("equipment")
                .getJSONObject("data")
                .getJSONArray("items");
        JSONObject val = obj.getJSONObject(index);
        JSONObject iteminfo = runItemManifestQuery(val.getInt("itemHash"));
        return iteminfo;
    }

    public String getItemName(JSONObject iteminfo){
        return iteminfo.getJSONObject("displayProperties").get("name").toString();
    }

    public BufferedImage getItemImage(JSONObject iteminfo){
        String imageBaseURL = "https://www.bungie.net";
        String imageInfo = iteminfo.getJSONObject("displayProperties").get("icon").toString();
        try {
            URL imageURL = new URL(imageBaseURL + imageInfo);
            BufferedImage image = ImageIO.read(imageURL);
            return image;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
