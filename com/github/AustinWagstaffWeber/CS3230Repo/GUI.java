package com.github.AustinWagstaffWeber.CS3230Repo;

import javax.swing.*;

public class GUI {
    private JPanel panel1;
    private JButton stringOperationsButton;
    private JButton exitButton;
    private JButton mathOperationsButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CS3230 Project");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
