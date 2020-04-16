package com.us.solutions;

public class ToLowerCase {
    //Leet code 709
    public static void main(String[] args) {
        System.out.println(new ToLowerCase().convert("Apple"));
    }

    private String convert(String s) {


        String result = "";

        char[] chars = s.toCharArray();
        for(char in: chars){
            int numericValue = in;
            if(65 <= numericValue && numericValue <= 90){
                numericValue = numericValue+32;
                char numericValue1 = (char) numericValue;
                result = result + numericValue1;

            }else{
                result = result + in;
            }
        }
        return result;
    }
}
