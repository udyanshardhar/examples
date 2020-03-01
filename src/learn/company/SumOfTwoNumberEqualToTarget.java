package com.company;

public class SumOfTwoNumberEqualToTarget {
        public int strStr(String haystack, String needle) {
            if(needle == null || needle.length() == 0)
                return 0;
            char needleFirstChar = needle.charAt(0);
            int needleSize = needle.length();
            char[] hayStackList = haystack.toCharArray();
            for(int i =0; i < haystack.length() - needleSize; i++){
                if(needleFirstChar == hayStackList[i]){
                    String temp = haystack.substring(i, i+needleSize);
                    if(temp.equals(needle))
                        return i;
                }
            }

            return -1;
        }

        public static void main(String arg[]){
            System.out.println(new SumOfTwoNumberEqualToTarget().strStr("hello", "ll"));

        }
}
