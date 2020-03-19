import learn.ListNode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class RemoveDuplicateFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode node = new RemoveDuplicateFromLinkedList().removeDuplicate(head);
        System.out.println(node);
    }

    private ListNode removeDuplicate(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode current= head;
        while(current.nextNode != null){

            if(current.value == current.nextNode.value){
                current.nextNode = current.nextNode.nextNode;
            }else {
                current = current.nextNode;
            }

        }

        return head;

    }
}
