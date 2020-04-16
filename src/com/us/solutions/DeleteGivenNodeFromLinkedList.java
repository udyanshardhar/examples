package com.us.solutions;

public class DeleteGivenNodeFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, new ListNode(7)))));

        new DeleteGivenNodeFromLinkedList().deleteNode(head.nextNode);
    }

    public void deleteNode(ListNode node){

        if(node.nextNode != null){
            node.value = node.nextNode.value;
            node.nextNode = node.nextNode.nextNode;
        }
    }
}
