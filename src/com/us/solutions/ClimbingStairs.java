package com.us.solutions;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climb(2));

    }

    public int climb(int stairs){
        int [] dp = new int[stairs+1];
        dp[0] =1;
        dp[1]= 1;
        for(int i =2; i<=stairs; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[stairs];
    }
}
