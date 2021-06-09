import java.util.Scanner;

public class Main {

    public static int[] inputSet;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        
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
            temp = runCommand(commandInput, inputSet);
        }

        sc.close();
    }

    public static void displayMenu(){
        System.out.println("Supported Commands:");
        System.out.println("- sum : sum of integer set");
        System.out.println("- evens : find the evens in the integer set");
        System.out.println("- odds : find the odds in the integer set");
        System.out.println("- max : find the maximum value in the integer set");
        System.out.println("- min : find the minimum value in the integer set");
        System.out.println("- update : enter in a new integer set");
        System.out.println("- exit : exit program");
    }

    public static boolean runCommand(String command, int[] input){
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
                System.out.println("Max: " + Math.min(input));
                break;
            case "update":
                        update(sc);
                        break;
            case "exit":
                        System.out.println("Goodbye!");
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
}