package com.us.solutions.queue;


import com.us.solutions.linkedList.ListNode;

public class LinkedQueue {
    private int length;
    private ListNode front, rear;

    public LinkedQueue(){
        this.length = 0;
        this.rear = this.front = null;
    }

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if(isEmpty()){
            rear = temp;
        }else {
            rear.setNext(temp);
            rear = temp;
        }
        length++;
    }

    public int dequeue() throws Exception{
        int data;
        if(isEmpty()) {
            throw  new Exception("");
        }
        data = front.getData();
        front = front.getNext();
        length--;

        if(isEmpty()){
            rear = null;
        }
        return data;
    }

    public boolean isEmpty(){
        return length == 0;
    }
}
