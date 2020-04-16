package com.us.solutions;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(new SquareRoot().findsqrt(16));
    }

    private int findsqrt(int x) {
        int leftNum = 1;
        int rightNum = x;
        int medium;
        if(x == 2 | x == 1){
            return 1;
        }

        while(leftNum < rightNum){
            medium = leftNum + Math.round((rightNum -leftNum)/2);
            if(medium * medium == x){
                return medium;
            }else if(Math.pow(medium, 2) > x){
                rightNum = medium;
            }else if(Math.pow(medium, 2) < x){
                leftNum = medium +1;
            }
        }

        return leftNum-1;
    }
}
