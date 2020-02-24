package learn;

import java.util.Objects;

public class SingleLinkedList {

    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node previousNode, int data) {
        Objects.requireNonNull(previousNode, "previous object can not be null");
        Node newNode = new Node(data);
        Node nextNode = previousNode.next;
        previousNode.next = newNode;
        newNode.next = nextNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node lastNode = head;
        while(lastNode.next != null){
            lastNode =lastNode.next;
        }

        lastNode.next = newNode;
    }

    public void deleteNode(int key){
        Node temp = head, previousNode = null;
        if(temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while(temp != null && temp.data != key){
            previousNode = temp;
            temp = temp.next;
        }
        if (temp == null){
            return;
        }
        previousNode.next = temp.next;
    }

    public void printLinkedList(){
        StringBuilder sb = new StringBuilder();
        Node print = head;
        while (print != null){
            sb.append(print.data);
            sb.append("--->");
            print = print.next;
        }
        sb.deleteCharAt(sb.lastIndexOf("--->"));

        System.out.println(sb);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        Node print = this.head;
        while (print != null){
            sb.append(print.data);
            sb.append("--->");
            print = print.next;
        }
        sb.deleteCharAt(sb.lastIndexOf("--->"));
        return sb.toString();
    }

}
