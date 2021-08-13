package com.github.AustinWagstaffWeber.CS3230Repo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DestinyInventory {
    private JTextField textField1;
    private JPanel root;
    private JButton submitButton;
    private JLabel helmetName;
    private JLabel armName;
    private JLabel chestName;
    private JLabel legsName;
    private JLabel kineticName;
    private JLabel energyName;
    private JLabel powerName;
    private JLabel ghostName;

    public DestinyInventory() {
        submitButton.addActionListener(e -> {
            Data d = new Data();
            String user = textField1.getText();
            ProfileInfo p = new ProfileInfo(user);

            kineticName.setText(d.getItemName(d.getCharacterItem(0,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            energyName.setText(d.getItemName(d.getCharacterItem(1,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            powerName.setText(d.getItemName(d.getCharacterItem(2,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            ghostName.setText(d.getItemName(d.getCharacterItem(7,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));

            helmetName.setText(d.getItemName(d.getCharacterItem(3,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            armName.setText(d.getItemName(d.getCharacterItem(4,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            chestName.setText(d.getItemName(d.getCharacterItem(5,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            legsName.setText(d.getItemName(d.getCharacterItem(6,p.getMembershipType(),p.getMembershipID(),p.getCharacterID())));
            //kinteticImage = new JLabel(new ImageIcon(d.getItemImage(d.getCharacterItem(0,d.getMemberType(user),d.getMemberID(user),d.getCharacter(0,d.getMemberType(user),d.getMemberID(user))))));


        });
    }

    public JPanel getRoot() {
        return root;
    }

    public void run() {
        JFrame frame = new JFrame("CS3230 Project");
        JLabel bless;
        try {
            URL url = new URL("https://i.imgur.com/AD3MbBi.jpeg");
            BufferedImage image = ImageIO.read(url);
            bless = new JLabel(new ImageIcon(image));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setContentPane(new DestinyInventory().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(10000,10000);
        frame.pack();
        frame.setVisible(true);
        URL url = null;


    }
}
