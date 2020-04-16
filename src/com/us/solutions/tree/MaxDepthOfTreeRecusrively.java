package com.us.solutions.tree;

public class MaxDepthOfTreeRecusrively {
    public static int maxDepth(BinaryTreeNode root) {
        if(root == null)
            return 0;

        int leftMax = maxDepth(root.getLeftChild());
        int rightMax = maxDepth(root.getRightChild());
        return leftMax <= rightMax ? rightMax+1 : leftMax+1;
    }
}
