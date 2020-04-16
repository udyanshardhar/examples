package com.us.solutions.tree;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getData() {
        return data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public BinaryTreeNode find(int data) {
        if(this.data == data)
            return this;
        
        if(data < this.data && this.getLeftChild() != null){
            return this.getLeftChild().find(data);
        }else if(data > this.data && this.getRightChild() != null){
            return this.getRightChild().find(data);
        }
        return null;
    }

    public void insert(int data) {
       if(data < this.data){
           if(this.getLeftChild() == null)
               this.setLeftChild(new BinaryTreeNode(data));
           else 
               this.getLeftChild().insert(data);
       }else {
           if(this.getRightChild() == null)
               this.setRightChild(new BinaryTreeNode(data));
           else
               this.getRightChild().insert(data);
       }
    }


    public String toString(){
        return String.valueOf(this.data);
    }
}
