package com.us.solutions;

public class ReversebyKStep {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        new ReversebyKStep().reversebykstep(nums, 2);
        System.out.println(nums);
        // new com.us.solutions.ReversebyKStep().reversebykstep(new int[]{}, 3);
    }

    private void reversebykstep(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int startIndex, int lastIndex) {

        while (startIndex < lastIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }
    }
}
