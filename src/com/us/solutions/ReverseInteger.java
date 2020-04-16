package com.us.solutions;


public class ReverseInteger {

    public static void main(String[] args) {
        System.err.println(new ReverseInteger().reverseInteger(-412));
        System.out.println(new ReverseInteger().reverseInteger(-3424));
        System.out.println(new ReverseInteger().reverseInteger(121));
        System.out.println(new ReverseInteger().reverseInteger(3333));
        System.out.println(new ReverseInteger().reverseInteger(8778));

    }

    public int reverseInteger(int input) {
        int flag = input < 0 ? -1 : 1;
        int current = input * flag;
        int reverse = 0;
        while(current != 0) {
            reverse = reverse * 10 + current % 10;
            current = Math.floorDiv(current,  10);
        }
        if(reverse > Math.pow(2, 31) -1) {
            return 0;
        }
        return reverse * flag;
    }
}
