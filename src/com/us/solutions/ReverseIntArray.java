package com.us.solutions;

public class ReverseIntArray {
    public static void main(String[] args) {
        System.out.println(new ReverseIntArray().reverse(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new ReverseIntArray().reverse(new int[]{1}));
        System.out.println(new ReverseIntArray().reverse(new int[]{}));
    }

    public int[] reverse(int[] nums) {

        for(int index = 0; index < nums.length/2; index++){
            int temp = nums[index];
            nums[index] = nums[nums.length-index-1];
            nums[nums.length-index-1] = temp;
        }

        return nums;
    }
}
