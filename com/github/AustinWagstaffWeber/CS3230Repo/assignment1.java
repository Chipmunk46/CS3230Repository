package com.github.AustinWagstaffWeber.CS3230Repo;

import java.util.ArrayList;

public class assignment1 {
    public static void main(String[] args){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (String s : args){
            values.add(Integer.parseInt(s));
        }

        int sum = 0;
        for (int i = 1; i < values.size(); i++){
            sum += values.get(i);
        }

        System.out.println("Sum: " + sum);


        System.out.print("Evens: ");
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for (int i = 1; i < values.size(); i++){
            if (values.get(i) % 2 == 0){
                evens.add(values.get(i));
            }
        }
        for (int i : evens){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Odds: ");
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for (int i = 1; i < values.size(); i++){
            if (values.get(i) % 2 != 0){
                odds.add(values.get(i));
            }
        }
        for (int i : odds){
            System.out.print(i + " ");
        }
        System.out.println();

        int max = values.get(1);
        for (int i = 1; i < values.size(); i++){
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Max: " + max);

        int min = values.get(1);
        for (int i = 1; i < values.size(); i++){
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Min: " + min);


    }
}