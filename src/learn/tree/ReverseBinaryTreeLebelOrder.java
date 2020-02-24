package learn.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseBinaryTreeLebelOrder {

    public static void levelOrderTraversalReverse(BinaryTreeNode root) {

        if(root == null){
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();

            if(temp != null) {
                if(temp.getLeftChild() != null){
                    queue.offer(temp.getLeftChild());
                }

                if(temp.getRightChild() != null) {
                    queue.offer(temp.getRightChild());
                }
            }

            stack.push(temp);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }
}
