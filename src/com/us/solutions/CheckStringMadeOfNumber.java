package com.us.solutions;

import java.util.regex.Pattern;

public class CheckStringMadeOfNumber {
    public static void checkStringMadeOfNumber(String [] inputs) {
        Pattern pattern = Pattern.compile(".*\\D.*");
        for(String input: inputs){
            System.out.println( "does " + input + " is number : "
                    + !pattern.matcher(input).matches());
        }
    }
}
