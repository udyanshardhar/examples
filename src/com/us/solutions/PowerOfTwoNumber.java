package com.us.solutions;

public class PowerOfTwoNumber {

    // 231
    public static void main(String[] args) {
        System.out.println(new PowerOfTwoNumber().isPowerOfTwo(16));
        System.out.println(new PowerOfTwoNumber().isPowerOfTwo(2));
        System.out.println(new PowerOfTwoNumber().isPowerOfTwo(3));
        System.out.println(new PowerOfTwoNumber().isPowerOfTwo(218));

    }

    private boolean isPowerOfTwo(int n) {
        int powerOf = 2;
        if(n < powerOf){
            return false;
        }
        while(powerOf <= n){
            if(powerOf == n){
                return true;
            }
            powerOf = powerOf * 2;
        }
        return false;
    }
}
