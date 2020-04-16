package com.us.solutions;

public class Node {
    int value;
    Node nextNode;
    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(int value, Node node) {
        this.value = value;
        this.nextNode = node;
    }

    public boolean equals(Object obj) {

        if(obj instanceof Node && ((Node) obj).value == this.value) {
            return true;
        }
        return false;
    }
}
