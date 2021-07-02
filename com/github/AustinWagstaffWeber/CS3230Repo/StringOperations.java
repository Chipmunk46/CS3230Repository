package com.github.AustinWagstaffWeber.CS3230Repo;

import java.util.ArrayList;
import java.util.List;

public class StringOperations {

    public static List<Boolean> isPalindrome(List<String> input){
        List<Boolean> bools = new ArrayList<Boolean>();
        for (String s : input){
            StringBuilder sbr = new StringBuilder(s);
            sbr.reverse();
            if (s.equals(String.valueOf(sbr))) {
                bools.add(true);
            } else {
                bools.add(false);
            }
        }
        return bools;
    }
}
