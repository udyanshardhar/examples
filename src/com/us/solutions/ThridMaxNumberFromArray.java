package com.us.solutions;

public class ThridMaxNumberFromArray {
    public static void main(String[] args) {
        System.out.println( new ThridMaxNumberFromArray().thirdMax(new int[]{1, 3, 4, 2, 5}));
    }

    public int thirdMax(int[] nums) {
        int max1 = nums[0];
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int i = 1; i< nums.length; i++){
            int current = nums[i];
            if(current > max1){

            }
            if(current > max2){

            }

            if(current > max3){

            }
        }
        return  0;
    }
}
