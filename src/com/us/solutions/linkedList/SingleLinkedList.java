package com.us.solutions.linkedList;

import com.us.solutions.ListNode;

public class SingleLinkedList {
    private ListNode head;
    private int length;

    public SingleLinkedList() {
        this.length = 0;
        this.head = null;
    }

    public int getLength() {
        return length;
    }

    public synchronized ListNode getHead(){
        return head;
    }

    public synchronized void insertAtBegin(ListNode newNode){
        newNode.nextNode = head;
        head = newNode;
        length++;
    }

    public synchronized void insertAtEnd(ListNode newNode){
        if(head != null){
            ListNode currentNode = head;
            while (currentNode.nextNode != null){
                System.out.println("current node is =>" + currentNode.value);
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode = null;
            currentNode.nextNode = newNode;
        }else {
            head = newNode;
        }
        length++;

    }

    public synchronized void insertAtPosition(int data, int position) {
        if(position < 0){
            position = 0;
        }
        if(position >= length){
            position = length;
        }

        if (position == 0) {
            ListNode tempNode = new ListNode(data);
            tempNode.nextNode = head;
            head = tempNode;
            length++;
        }else {
            ListNode currentNode = head;
            for(int i = 1; i < position; i++) {
                currentNode =currentNode.nextNode;
            }
            ListNode newNode = new ListNode(data);
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
        length++;
    }

    public synchronized ListNode removeFromBegin(){

        ListNode temp = head;
        if(temp != null){
            head =temp.nextNode;
            temp.nextNode = null;
        }
        return temp;

    }
    public synchronized ListNode removeFromEnd(){

        if(head == null)
            return null;

        ListNode secondLastNode = head, lastNode = head.nextNode;
        if(lastNode == null){
            head = null;
            return secondLastNode;
        }else {
         while (lastNode.nextNode != null)  {
             secondLastNode = lastNode;
             lastNode = lastNode.nextNode;
         }

        }
        secondLastNode.nextNode = null;
        return lastNode;
    }

    public synchronized boolean removeMatched(ListNode nodeToBeRemoved){
        if(head == null){
            return false;
        }
        if(nodeToBeRemoved.equals(head)){
            head = null;
            return true;
        }
        ListNode previousNode=head, currentNode = head.nextNode;
        while (currentNode != null && currentNode.nextNode != null){
            if(currentNode.equals(nodeToBeRemoved)){
                previousNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = null;
                currentNode = null;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        return false;
    }

    public void removePosition(int position) {

        if(position < 0) {
            position = 0;
        }

        if (position >= length){
            position = length-1;
        }

        if(head == null)
            return;

        if(position == 0){
            head=  head.nextNode;
        }else {

            ListNode temp = head;
            for(int i=1; i<position; i++){
                temp = temp.nextNode;
            }

            temp.nextNode = temp.nextNode.nextNode;
        }
        length--;

    }

    public String toString(){
        String result = "[";
        if(head == null){
            return result = result + "]";
        }

        result = result + head.value;
        ListNode temp  = head.nextNode;
        while(temp != null){
            result = result + "->" + temp.value;
            temp = temp.nextNode;
        }
        return result + "]";
    }
}
