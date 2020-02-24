package learn.linkedList;

import java.util.HashMap;
import java.util.Hashtable;

public class LinkedListExcercise {

    // Delete the nth node from end.

    public ListNode deleteNthNodeFromEnd(ListNode head, int n){
        ListNode temp = head, nthNode = null;
        for(int i =1; i < n; i++){
            if(temp != null){
                temp = temp.getNext();
            }
        }

        while(temp != null){
            if(nthNode == null){
                nthNode= head;
            }else {
                nthNode = nthNode.getNext();
            }

            temp = temp.getNext();
        }

        if(nthNode != null){
            return nthNode;
        }

        return null;
    }

    // Take two pointers and move them on different speed. If the link is circular them they must meet some place.
    public boolean findIfLoopExistUsingFloyed(ListNode head){
        ListNode fastptr = head;
        ListNode slowptr = head;

        while (fastptr != null && fastptr.getNext() != null){
            fastptr = fastptr.getNext().getNext();
            slowptr = slowptr.getNext();
            if(fastptr == slowptr){
                return true;
            }
        }
        return false;
    }

    // traverse the list and put in hashTable. if the node you travel next already in table that mean it is circular list.
    public boolean findIfLoopExistUsingHashTable(ListNode head){
        ListNode temp = head;
        Hashtable<ListNode, Integer> ht = new Hashtable<>();
        int i = 1;
        while (temp != null){
            ht.put(temp, i);
            if(ht.get(temp) != null){
                return true;
            }
            i++;
            temp = temp.getNext();
        }
        return false;
    }


    // Problem is to find if there is loop in LinkedList and if the loop then find the starting node of loop.
    // Take two pointers and move them on different speed. If the link is circular them they must meet some place.
    public ListNode findTheBeggingOfLoop(ListNode head){
        ListNode fastptr = head;
        ListNode slowptr = head;
        boolean loopExist = false;
        while (fastptr != null && fastptr.getNext() != null){
            fastptr = fastptr.getNext().getNext();
            slowptr = slowptr.getNext();
            if(fastptr == slowptr){
                loopExist = true;
            }
        }
        if(loopExist) {
            slowptr = head;
            while (slowptr != fastptr) {
                slowptr = slowptr.getNext();
                fastptr =fastptr.getNext();
            }
            return fastptr;
        }

        return null;
    }


    // Find the length of loop if there is circular list exist.
    // Take two pointers and move them on different speed. If the link is circular them they must meet some place.
    // when both pointer meet then just move one pointer until it come back to same node.
    // Time Complexity  O(n) and space complexity O(1)
    public int findTheLengthOfLoop(ListNode head){
        ListNode fastptr = head;
        ListNode slowptr = head;
        boolean loopExist = false;
        while (fastptr != null && fastptr.getNext() != null){
            fastptr = fastptr.getNext().getNext();
            slowptr = slowptr.getNext();
            if(fastptr == slowptr){
                loopExist = true;
            }
        }
        int length = 0;
        if(loopExist) {
            do {
                slowptr = slowptr.getNext();
                length++;
            } while (slowptr != fastptr);

            return length;
        }
        return length;
    }

    // Time complexity O(n) and space complexity O(1).
    public ListNode insertIntoSortedLinkedList(ListNode head, ListNode newNode) {
        ListNode current = head, previous = null;
        while ((current != null && current.getData() >= newNode.getData())){
            previous = current;
            current =current.getNext();
        }
        if(current == null){
            return newNode;
        }else if(previous == null) {
            newNode.setNext(current);
            return newNode;
        }else {
            newNode.setNext(current);
            previous.setNext(newNode);
            return head;
        }
    }

    // Time complexity O(n) and space complexity O(1).
    public ListNode reverseSinglyLinkedList(ListNode head){
        ListNode previous = null, current = head;
        while(current != null){
            // save the next node.
            ListNode next = current.getNext();
            // make the current node point to previous.
           current.setNext(previous);
           // make current not previous.
           previous = current;
           // next node to current.
            current = next;
        }
        return previous;
    }


    public ListNode FindMergingPointOfTwoList(ListNode ll1, ListNode ll2) {

        HashMap<ListNode, Integer> hm = new HashMap<>();
        while (ll1 != null) {
            hm.put(ll1, 1);
            ll1 = ll1.getNext();
        }
        while (ll2 != null){
            if(hm.containsKey(ll2))
                return ll2;
        }
        return null;
    }

    // Can be solved by creating hashMap and then get the middle object, HashMap<Integer, ListNode>.
    // Keep two pointer and move one to double of first one each time. 
    public ListNode findMiddleOfList(ListNode head) {

        return null;
    }
}
