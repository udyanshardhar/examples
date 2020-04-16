package com.us.solutions.tree;

public class BinarySearchTree {

    private BinaryTreeNode root;

    public BinaryTreeNode find(int data) {
        if (root == null)
            return null;
        return root.find(data);
    }

    public void insert(int data) {
        if (root != null){
            root.insert(data);
        }else {
            this.root = new BinaryTreeNode(data);
        }
    }

    public void delete(int input){
        BinaryTreeNode current = this.root;
        BinaryTreeNode parent = this.root;
        boolean isLeftChild = false;
        if(current == null) {
            return;
        }

        while(current != null && current.getData() != input) {

            parent = current;
            if(input < current.getData()) {
               current = current.getLeftChild();
               isLeftChild = true;
            }else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }

        if(current == null) {
            return;
        }

        if(current.getLeftChild() == null && current.getRightChild() == null) {
            if(current == this.root){
                current = null;
            }else if(isLeftChild){
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
        }else if(current.getRightChild() == null){
            if(current == root){
                root = current.getLeftChild();
            }else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            }else {
                parent.setRightChild(current.getLeftChild());
            }
        }else if(current.getLeftChild() == null){
            if(current == root){
                root = current.getRightChild();
            }else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            }else {
                parent.setRightChild(current.getRightChild());
            }
        }else {

            BinaryTreeNode successorParent = current.getRightChild();;
            BinaryTreeNode successor = current.getRightChild();
            while (successor.getLeftChild() != null){
                successorParent = successor;
                successor = successor.getLeftChild();

            }

        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        System.out.println(tree.find(5));
    }
}
