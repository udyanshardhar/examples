package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeInBT {

    public static BinaryTreeNode deepestNode(BinaryTreeNode root) {

        BinaryTreeNode temp = null;

        if(root == null)
            return null;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if(temp!= null) {
                if(temp.getLeftChild() != null) {
                    queue.offer(temp.getLeftChild());
                }
                if(temp.getRightChild() != null) {
                    queue.offer(temp.getRightChild());
                }
            }
        }

        return temp;
    }
}
