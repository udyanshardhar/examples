package com.us.solutions.linkedList;

public class CircularLinkedList {

    private CLLNode tail;
    private int length;

    public CircularLinkedList() {
        this.tail = null;
        this.length = 0;
    }


    public void addToHead(int data){
        CLLNode temp = new CLLNode(data);
        if(tail == null){
            tail = temp;
            tail.setNext(tail);
        }else {

            temp.setNext(tail.getNext());
            tail.setNext(temp);
        }
        length++;
    }

    public void addElementToTail(int data){
        addToHead(data);
        tail = tail.getNext();
    }

    public int peak(){
            return tail.getNext().getData();
    }

    public int tailPeek(){
        return tail.getData();
    }

    public int removeFromHead(){
        CLLNode temp  = tail.getNext();

        if(temp == temp.getNext()){
            tail = null;
        }else {
            tail.setNext(temp.getNext());
            temp.setNext(null);
        }

        length--;

        return temp.getData();
    }

}
