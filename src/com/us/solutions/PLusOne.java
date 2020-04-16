package com.us.solutions;

public class PLusOne {
    public static void main(String[] args) {
        int[] addone = new PLusOne().addone(new int[]{1, 9,9,9});
        System.out.println(addone);
    }

    private int[] addone(int[] digits) {

        for(int position = digits.length-1; position >=0; position--){
            if(digits[position] != 9){
                digits[position] = digits[position]+1;
                return digits;
            }else {
                digits[position] = 0;
            }

       }
        int[] result = new int[digits.length+1];

        result[0] = 1;
        int pos = 1;
        while (pos <= digits.length){
            result[pos] = digits[pos-1];
            pos++;
        }
        return result;
    }
}
