package com.github.AustinWagstaffWeber.CS3230Repo;

import javax.swing.*;

public class GUIMath {
    private JTextField textField1;
    private JButton maximumValueButton;
    private JButton minimumValueButton;
    private JButton evenValuesButton;
    private JButton sumOfValuesButton;
    private JButton oddValuesButton;
    private JButton standardDeviationButton;
    private JButton fiveNumberSummaryButton;
    private JButton exitProgramButton;
    private JPanel rootPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CS3230 Project");
        frame.setContentPane(new GUIMath().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
