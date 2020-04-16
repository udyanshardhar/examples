package com.us.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindInBinaryTree {
    public static boolean findInBTRecursive(BinaryTreeNode root, int data) {
        if(root == null){
            return false;
        }

        if(root.getData() == data){
            return true;
        }
        return findInBTRecursive(root.getLeftChild(), data)  || findInBTRecursive(root.getRightChild(), data);
    }

    // Keep adding the elements from binary tree to queue and keep checking the data.
    public static boolean findInBTIterative(BinaryTreeNode root, int data) {
        if(root == null) {
            return false;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            if(temp != null && temp.getData() == data){
                return true;
            }

            if(root.getLeftChild() != null){
                queue.offer(root.getLeftChild());
            }else if (root.getRightChild() != null) {
                queue.offer(root.getRightChild());
            }

        }
        return false;
    }

}
