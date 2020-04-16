package com.us.solutions;

class Node {
    int value;
    Node nextNode;
   public Node(int value) {
       this.value = value;
       this.nextNode = null;
   }
    public Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3)));
        new ReverseLinkedList().printLinkedList(root);
        System.out.println();
        new ReverseLinkedList().printLinkedList(new ReverseLinkedList().reverseLinkList(root));

    }

    public void printLinkedList(Node node){
        while(node != null){
            System.out.print(String.format("%s -> ", node.value));
            node = node.nextNode;
        }
        System.out.print(String.format("null"));
    }
    public Node reverseLinkList(Node head) {
        Node previous = null;
        Node next = null;
        while (head != null){
            next = head.nextNode;
            head.nextNode = previous;
            previous = head;
            head = next;

        }

        return previous;
    }

}
