package com.us.solutions;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = new int[]{-1, 2, 3, -5, 4};
        System.out.println(new MaxSubArray().findMaxArray(input));
    }

    private int findMaxArray(int[] nums) {
        int globalSum = nums[0];
        for(int i =0; i <nums.length; i++){
            int currentSum = nums[i];
            for (int j = i+1; j < nums.length; j++){
                currentSum = currentSum + nums[j];
                if(currentSum > globalSum){
                    globalSum = currentSum;
                }
            }
            if(currentSum > globalSum){
                globalSum = currentSum;
            }
        }
        return globalSum;
    }
}
