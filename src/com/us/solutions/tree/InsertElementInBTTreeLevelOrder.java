package com.us.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElementInBTTreeLevelOrder {
    public static BinaryTreeNode insertElement(BinaryTreeNode root, int data) {
        if(root == null){
            return null;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();

            if(temp != null) {
                if(temp.getLeftChild() == null){
                    temp.setLeftChild(new BinaryTreeNode(data));
                    return root;
                }else {
                    queue.offer(temp.getLeftChild());
                }

                if(temp.getRightChild() == null){
                    temp.setRightChild(new BinaryTreeNode(data));
                    return root;
                }else {
                    queue.offer(temp.getRightChild());
                }
            }
        }
        return null;
    }
}
