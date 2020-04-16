package com.us.solutions;

public class ReverseCharArray {

    public char[] reverseCharArray(char[] s) {

        for(int index = 0; index < s.length/2; index++){
            char temp = s[index];
            s[index] = s[s.length-index-1];
            s[s.length-index-1] = temp;
        }

        return s;
    }
}
