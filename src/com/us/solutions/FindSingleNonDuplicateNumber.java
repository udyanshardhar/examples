package com.us.solutions;

import java.util.HashSet;

public class FindSingleNonDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(new FindSingleNonDuplicateNumber().findSingleNonDuplicateNumber(new int[]{1,3,1,4,4}));
    }

    private Integer findSingleNonDuplicateNumber(int[] nums){
        HashSet<Integer> temp = new HashSet<>();
        for(int in: nums){
            if(temp.contains(in)){
                temp.remove(in);
            }else{
                temp.add(in);
            }
        }

        return (Integer) temp.toArray()[0];
    }
}
