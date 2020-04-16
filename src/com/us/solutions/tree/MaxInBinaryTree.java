package com.us.solutions.tree;

public class MaxInBinaryTree {
    public int solution(BinaryTreeNode root){

        int maxValue = Integer.MIN_VALUE;
        if(root != null){
            int leftValue = solution((root.getLeftChild()));
            int rightValue = solution((root.getRightChild()));
            if(leftValue > rightValue) {
                maxValue = leftValue;
            }else {
                maxValue = rightValue;
            }
            maxValue = root.getData() > maxValue ? root.getData() : maxValue;
        }

        return maxValue;
    }
}
