package com.us.solutions;

public class ListNode {
    public int value;
    public ListNode nextNode;

    public ListNode(int value){
        this.value =value;
    }
    public ListNode(int value, ListNode nextNode){
        this.value =value;
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
