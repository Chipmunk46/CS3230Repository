package com.github.AustinWagstaffWeber.CS3230Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {

    public static int[] inputSet;
    public static Scanner sc = new Scanner(System.in);

    public static void displayMenu(){
        System.out.println("Supported Commands:");
        System.out.println("- sum : sum of integer set");
        System.out.println("- evens : find the evens in the integer set");
        System.out.println("- odds : find the odds in the integer set");
        System.out.println("- max : find the maximum value in the integer set");
        System.out.println("- min : find the minimum value in the integer set");
        System.out.println("- summary : find the 5 number summary of integer set");
        System.out.println("- stdev : find the standard deviation of integer set");
        System.out.println("- update : enter in a new integer set");
        System.out.println("- exit : exit program");
    }

    public static void displayStringMenu(){
        System.out.println("Available Commands: ");
        System.out.println("ispalindrome : lists if each member of string list is palindrome");
        System.out.println("Exit: Exit the program");
    }

    public static void displayMainMenu(){
        System.out.println("Available Commands:");
        System.out.println("- stringops : operations on strings");
        System.out.println("- math : operations involving math");
        System.out.println("- exit : exit cli");
    }

    public static boolean runMainCommands(String command){
        switch (command) {
            case "stringops":
                startString();
                break;
            case "math":
                startInt();
                break;
            case "exit":
                System.out.println("Goodbye!");
                return false;
            default:
                return true;
        }
        return true;
    }

    public static boolean runStringCommand(String command, List<String> input){
        switch (command) {
            case "ispalindrome":
                List<Boolean> bools = StringOperations.isPalindrome(input);
                for (int i = 0; i < input.size(); i++){
                    System.out.println("Is " + input.get(i) + " a palindrome? " + bools.get(i));
                }
                break;
            case "exit":
                init();
                return false;
            default:
                return true;
        }
        return  true;
    }


    public static boolean runIntCommand(String command, int[] input){
        switch (command){
            case "sum":
                System.out.println("Sum: " + Math.sum(input));
                break;
            case "evens":
                System.out.print("Evens: ");
                for (Integer i : Math.evens(input)){
                    System.out.print(i + " ");
                }
                System.out.println();
                break;
            case "odds":
                System.out.print("Odds: ");
                for (Integer i : Math.odds(input)){
                    System.out.print(i + " ");
                }
                System.out.println();
                break;
            case "max":
                System.out.println("Max: " + Math.max(input));
                break;
            case "min":
                System.out.println("Min: " + Math.min(input));
                break;
            case "stdev":
                System.out.printf("Stdev: %.4f", Math.stdev(input));
                break;
            case "summary":
                int[] summary = Math.summary(input);
                System.out.printf("5 Number Summary %d, %d, %d, %d, %d \n", summary[0],summary[1],summary[2],summary[3],summary[4]);
                break;
            case "update":
                update(sc);
                break;
            case "exit":
                init();
                return false;
            default:
                return true;
        }

        return true;
    }

    public static void update(Scanner sc){
        System.out.println("Input a list of integers: (single spaces)");
        String input = sc.nextLine();
        String[] inputStrings = input.split(" "); // split inputstring apart into individual strings
        inputSet = new int[inputStrings.length];
        // convert inputstrings into integers
        for(int i = 0; i < inputStrings.length; i++){
            inputSet[i] = Integer.parseInt(inputStrings[i]);
        }
    }

    public static void init(){
        System.out.println("Welcome to Austin Wagstaff's CLI!");
        displayMainMenu();
        System.out.println("Enter in the command based on where you desire to go:");
        String input = sc.nextLine();
        runMainCommands(input);
    }

    public static void startString(){
        System.out.println("Welcome to the stringops menu!");
        System.out.println("Input a list of strings to operate on:");
        String input = sc.nextLine();
        String[] inputStrings = input.split(" ");
        List<String> strings = new ArrayList<String>();
        for (String s : inputStrings){
            strings.add(s);
        }
        boolean temp = true;
        while (temp){
            displayStringMenu();
            System.out.print("Enter Command: ");
            String commandInput = sc.nextLine();
            temp = runStringCommand(commandInput, strings);
        }
    }
    public static void startInt(){
        System.out.println("Welcome to the best worst number cruncher program!");
        System.out.println("Input a list of integers: (single spaces)");
        String input = sc.nextLine();

        String[] inputStrings = input.split(" "); // split inputstring apart into individual strings
        inputSet = new int[inputStrings.length];
        // convert inputstrings into integers
        for(int i = 0; i < inputStrings.length; i++){
            inputSet[i] = Integer.parseInt(inputStrings[i]);
        }
        boolean temp = true;
        while (temp){
            displayMenu();
            System.out.print("Enter Command: ");
            String commandInput = sc.nextLine();
            temp = runIntCommand(commandInput, inputSet);
        }

        sc.close();
    }


}
