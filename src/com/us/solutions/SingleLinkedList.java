package com.us.solutions;

import java.util.Objects;

public class SingleLinkedList {

    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        head = newNode;
    }

    public void insertAfter(Node previousNode, int data) {
        Objects.requireNonNull(previousNode, "previous object can not be null");
        Node newNode = new Node(data);
        Node nextNode = previousNode.nextNode;
        previousNode.nextNode = newNode;
        newNode.nextNode = nextNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node lastNode = head;
        while(lastNode.nextNode != null){
            lastNode =lastNode.nextNode;
        }

        lastNode.nextNode = newNode;
    }

    public void deleteNode(int key){
        Node temp = head, previousNode = null;
        if(temp != null && temp.value == key) {
            head = temp.nextNode;
            return;
        }

        while(temp != null && temp.value != key){
            previousNode = temp;
            temp = temp.nextNode;
        }
        if (temp == null){
            return;
        }
        previousNode.nextNode = temp.nextNode;
    }

    public void printLinkedList(){
        StringBuilder sb = new StringBuilder();
        Node print = head;
        while (print != null){
            sb.append(print.value);
            sb.append("--->");
            print = print.nextNode;
        }
        sb.deleteCharAt(sb.lastIndexOf("--->"));

        System.out.println(sb);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        Node print = this.head;
        while (print != null){
            sb.append(print.value);
            sb.append("--->");
            print = print.nextNode;
        }
        sb.deleteCharAt(sb.lastIndexOf("--->"));
        return sb.toString();
    }

}
