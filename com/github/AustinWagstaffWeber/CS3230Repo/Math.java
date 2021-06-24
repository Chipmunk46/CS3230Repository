package com.github.AustinWagstaffWeber.CS3230Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    // mean
    public static float mean(int[] values){
        float mean = 0;
        for (Integer i : values){
            mean += i;
        }
        mean /= values.length;
        return mean;
    }

    // standard deviation
    public static double stdev(int[] values){
        float mean = mean(values);
        int length = values.length;
        float std = 0;
        for (float num : values){
            std += java.lang.Math.pow((num-mean),2);
        }
        return java.lang.Math.sqrt(std/length);
    }

    public static int median(int[] values){
        Arrays.sort(values);
        int length = values.length;
        int med = 0;
        if (length % 2 == 0){
            med = (values[length/2] + values[length/2 - 1])/2;
        } else {
            med = values[length/2];
        }
        return med;
    }

    // 5 number summary
    public static int[] summary(int[] values){
        ArrayList<Integer> base = new ArrayList<Integer>();
        for (Integer i : values){
            base.add(i);
        }
        int[] summ = new int[5];
        summ[0] = min(values);
        summ[2] = median(values);
        summ[4] = max(values);
        ArrayList<Integer> lowerBound = new ArrayList<Integer>();
        ArrayList<Integer> upperBound = new ArrayList<Integer>();
        for (int i = 0; i < base.indexOf(median(values)); i++){
            lowerBound.add(base.get(i));
        }
        for (int i = base.indexOf(median(values))+1; i < base.size(); i++){
            upperBound.add(base.get(i));
        }
        int[] temp1 = lowerBound.stream().mapToInt(i -> i).toArray();
        int[] temp2 = upperBound.stream().mapToInt(i -> i).toArray();
        summ[1] = median(temp1);
        summ[3] = median(temp2);
        return summ;
    }
}
