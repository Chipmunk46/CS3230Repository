package com.github.AustinWagstaffWeber.CS3230Repo;

public class ProfileInfo {
    private int membershipType;
    private String membershipID;
    private String characterID;

    public ProfileInfo(String user){
        Data d = new Data();
        membershipType = d.getMemberType(user);
        membershipID = d.getMemberID(user);
        characterID = d.getCharacter(0,membershipType,membershipID);
    }

    public int getMembershipType() {
        return membershipType;
    }

    public String getMembershipID() {
        return membershipID;
    }

    public String getCharacterID() {
        return characterID;
    }
}
