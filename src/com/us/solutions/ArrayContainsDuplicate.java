package com.us.solutions;

import java.util.HashSet;

public class ArrayContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new ArrayContainsDuplicate().containsDuplicate(new int[]{3,3,5,5,3,4,4}));
    }

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> container = new HashSet<>();
        for(int num : nums){
            if(container.contains(num)){
                return true;
            }else{
                container.add(num);
            }
        }

        return false;
    }
}
