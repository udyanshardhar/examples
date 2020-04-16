package com.us.solutions;

public class RemoveDuplicateInPlace {

    public static void main(String[] args) {
        int[] input = new int []{1, 1, 5, 5, 5, 7};
                System.out.println(new RemoveDuplicateInPlace().removeDuplicateInPlace(input));
    }

    private int removeDuplicateInPlace(int[] input) {

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
