package com.us.solutions;

public class ReverseStringByRecursion {

    // Reverse a string using recursive method.
    public static String reverseStringByRecursion(String input, String result){
        if(input.length() == 1){
            result = result.concat(input);
            return result;
        }
        return result.concat(input.substring(input.length()-1))
                + reverseStringByRecursion(input.substring(0, input.length()-1), result);
    }

    public static void main(String[] args) {
        System.out.println("reverse of udyan is "+ reverseStringByRecursion("udyan", ""));
    }
}
