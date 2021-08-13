package com.github.AustinWagstaffWeber.CS3230Repo;

import javax.swing.*;
import java.net.URL;

public class MainGUI {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane;

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Main");
        MainGUI gui = new MainGUI();
        gui.getTabbedPane().addTab("Math",new GUIMath().getRootPanel());
        gui.getTabbedPane().addTab("Project",new DestinyInventory().getRoot());
        frame.setContentPane(gui.rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
