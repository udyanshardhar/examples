package com.us.solutions;

public class ReverseString {

    public static void main(String args[]){
        System.out.println(new ReverseString().reverse("dsfsdfsdf"));
    }

    private String reverse(String input) {
        char[] charArray = input.toCharArray();
        int startIndex =0;
        int lastIndex = charArray.length-1;

        String result = "";
        while(startIndex  < lastIndex){
            char temp = charArray[lastIndex];
            charArray[lastIndex] = charArray[startIndex];
            charArray[startIndex] = temp;
            startIndex ++;
            lastIndex --;
        }
        return  String.valueOf(charArray);
    }

}
