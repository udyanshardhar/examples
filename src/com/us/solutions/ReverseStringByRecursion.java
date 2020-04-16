package com.us.solutions;

public class ReverseStringByRecursion {

    // Reverse a string using recursive method.
    private static String reverse(String input, String result){
        if(input.length() == 1){
            result = result.concat(input);
            return result;
        }
        return result.concat(input.substring(input.length()-1))
                + reverse(input.substring(0, input.length()-1), result);
    }

    public static void main(String[] args) {
        System.out.println("reverse of udyan is "+ reverse("udyan", ""));
    }
}
