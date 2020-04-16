package com.us.solutions;

public class RemoveDuplicatesInArrayInPlace {

    public static void main(String[] args) {
        int[] input = new int []{1, 1, 5, 5, 5, 7};
                System.out.println(new RemoveDuplicatesInArrayInPlace().removeDuplicateInPlace(input));
    }

    public int removeDuplicateInPlace(int[] input) {

        int p1 =0;
        for (int p2 =1; p2< input.length; p2++){
            if(input[p1] != input[p2]){
                p1 =p1+1;
                input[p1] = input[p2];
            }
        }
        return p1+1;
    }
}
