package com.us.solutions;

// Leet code 28
public class FindFirstIndexOfNeedle {
    public static void main(String[] args) {
        String heys = "helullo";
        String needle = "ll";
        System.out.println(new FindFirstIndexOfNeedle().findNeedle(heys, needle));
    }

    private int findNeedle(String heys, String needle) {
        if(needle == null || needle.isEmpty())
            return 0;
        int needleLength = needle.length();
        if(heys!= null && !heys.isEmpty()) {
            for(int pointer1 =0; pointer1+needleLength < heys.length(); pointer1++){
                if(heys.substring(pointer1, pointer1+needleLength).equals(needle)){
                    return pointer1;
                }
            }
        }
        return 0;
    }
}
