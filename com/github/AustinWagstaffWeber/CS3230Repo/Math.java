package com.github.AustinWagstaffWeber.CS3230Repo;

import java.util.ArrayList;

public class Math {
    // sum of input set
    public static int sum(int[] values){
        int sum = 0;
        for (Integer i : values){
            sum += i;
        }
        return sum;
    }

    // even numbers in input set
    public static ArrayList<Integer> evens(int[] values){
        ArrayList<Integer> evenValues = new ArrayList<Integer>();
        for (Integer i : values){
            if (i % 2 == 0){
                evenValues.add(i);
            }
        }
        return evenValues;
    }

    // odd numbers in input set
    public static ArrayList<Integer> odds(int[] values){
        ArrayList<Integer> oddValues = new ArrayList<Integer>();
        for (Integer i : values){
            if (i % 2 != 0){
                oddValues.add(i);
            }
        }
        return oddValues;
    }

    // maximum value of input set
    public static int max(int[] values){
        int max = values[0];
        for (int i = 0; i < values.length; i++){
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    // minimum value in input set
    public static int min(int[] values){
        int min = values[0];
        for (int i = 0; i < values.length; i++){
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }
}
