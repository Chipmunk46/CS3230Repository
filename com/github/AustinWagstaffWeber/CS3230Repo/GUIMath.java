package com.github.AustinWagstaffWeber.CS3230Repo;

import javax.swing.*;
import java.util.ArrayList;

public class GUIMath {
    private JTextField textInput;
    private JButton maximumValueButton;
    private JButton minimumValueButton;
    private JButton evenValuesButton;
    private JButton sumOfValuesButton;
    private JButton oddValuesButton;
    private JButton standardDeviationButton;
    private JButton fiveNumberSummaryButton;
    private JPanel rootPanel;
    private JLabel outputValueDisplay;

    public GUIMath(){
        maximumValueButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            int max = Math.max(input);
            outputValueDisplay.setText(Integer.toString(max));
        }); //TODO
        minimumValueButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            int min = Math.min(input);
            outputValueDisplay.setText(Integer.toString(min));
        }); //TODO
        evenValuesButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            ArrayList<Integer> evens = Math.evens(input);
            outputValueDisplay.setText(listToString(evens));
        }); //TODO
        sumOfValuesButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            int sum = Math.sum(input);
            outputValueDisplay.setText(Integer.toString(sum));
        }); //TODO
        oddValuesButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            ArrayList<Integer> odds = Math.odds(input);
            outputValueDisplay.setText(listToString(odds));
        }); //TODO
        standardDeviationButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            double stdev = Math.stdev(input);
            outputValueDisplay.setText(Double.toString(stdev));
        }); //TODO
        fiveNumberSummaryButton.addActionListener(e -> {
            int[] input = getFieldInput(textInput.getText());
            int[] summary = Math.summary(input);
            StringBuilder sb = new StringBuilder();
            for (int i : summary){
                sb.append(i + " ");
            }
            outputValueDisplay.setText(sb.toString());
        }); //TODO
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("CS3230 Project");
        frame.setContentPane(new GUIMath().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static int[] getFieldInput(String s){
        String input = s;
        String[] inputStrings = input.split(" ");
        int[] inputSet = new int[inputStrings.length];
        for(int i = 0; i < inputStrings.length; i++){
            inputSet[i] = Integer.parseInt(inputStrings[i]);
        }
        return inputSet;
    }

    public static String listToString(ArrayList<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (Integer i : list){
            sb.append(i + " ");
        }
        return sb.toString();
    }
}
