package learn.tree;

public class TreeTraversal {

    public static void preOrderTraversal(BinaryTreeNode root){
        while (root != null){
            System.out.println(root.getData());
            preOrderTraversal(root.getLeftChild());
            preOrderTraversal(root.getRightChild());
        }
    }


    public static void inOrderTraversal(BinaryTreeNode root){
        while (root != null){
            inOrderTraversal(root.getLeftChild());
            System.out.println(root.getData());
            inOrderTraversal(root.getRightChild());
        }
    }

    public static void postOrderTraversal(BinaryTreeNode root){
        while (root != null){
            postOrderTraversal(root.getLeftChild());
            postOrderTraversal(root.getRightChild());
            System.out.println(root.getData());
        }
    }
}
