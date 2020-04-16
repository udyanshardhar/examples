package com.us.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TotalNumbersOfNodesInTree {

    public static int getNumberOfNodesRecursively(BinaryTreeNode root) {
        if(root == null){
            return 0;
        }

        int leftCount = root.getLeftChild() == null ? 0 : getNumberOfNodesRecursively(root.getLeftChild());
        int rightCount = root.getRightChild() == null ? 0 : getNumberOfNodesRecursively(root.getRightChild());
        return 1 + leftCount + rightCount;
    }

    public static int getNumberOfNodesIterative(BinaryTreeNode root) {

        int result = 0;

        if(root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            BinaryTreeNode node = queue.poll();

            if(node != null) {
                result++;
                if(node.getLeftChild() != null) {
                    queue.offer(node.getLeftChild());
                }else if(node.getRightChild() != null) {
                    queue.offer(node.getRightChild());
                }
            }
        }
        return result;
    }

}
