package com.us.solutions;


public class LongestCommonString {
    public static void main(String[] args) {
        String[] input = new String[]{"cc", "c"};
        System.out.println(new LongestCommonString().longestCommonString(input));
    }

public String longestCommonString(String[] strs) {
    String result = "";
    if(strs.length != 0){
        String str = strs[0];
        int inputLength = str != null ?str.length() : 0;
        if(inputLength > 0 && !str.equals("")) {
            for(int i = 0; i < inputLength; i++) {
                char temp = str.charAt(i);
                char temp1;
                for(int j = 1; j < strs.length; j++){
                    String str1 = strs[j];
                    if(str1.equals("") || !(str1.length() > i))
                        return result;
                    temp1 = str1.charAt(i);
                    if(temp != temp1){
                        return result;
                    }
                }
                result = result + temp;
            }
        }
    }

    return result;
}
}
