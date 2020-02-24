package learn.linkedList;

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
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    public synchronized void insertAtEnd(ListNode newNode){
        if(head != null){
            ListNode currentNode = head;
            while (currentNode.getNext() != null){
                System.out.println("current node is =>" + currentNode.getData());
                currentNode = currentNode.getNext();
            }
            newNode.setNext(null);
            currentNode.setNext(newNode);
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
            tempNode.setNext(head);
            head = tempNode;
            length++;
        }else {
            ListNode currentNode = head;
            for(int i = 1; i < position; i++) {
                currentNode =currentNode.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        length++;
    }

    public synchronized ListNode removeFromBegin(){

        ListNode temp = head;
        if(temp != null){
            head =temp.getNext();
            temp.setNext(null);
        }
        return temp;

    }
    public synchronized ListNode removeFromEnd(){

        if(head == null)
            return null;

        ListNode secondLastNode = head, lastNode = head.getNext();
        if(lastNode == null){
            head = null;
            return secondLastNode;
        }else {
         while (lastNode.getNext() != null)  {
             secondLastNode = lastNode;
             lastNode = lastNode.getNext();
         }

        }
        secondLastNode.setNext(null);
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
        ListNode previousNode=head, currentNode = head.getNext();
        while (currentNode != null && currentNode.getNext() != null){
            if(currentNode.equals(nodeToBeRemoved)){
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                currentNode = null;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
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
            head=  head.getNext();
        }else {

            ListNode temp = head;
            for(int i=1; i<position; i++){
                temp = temp.getNext();
            }

            temp.setNext(temp.getNext().getNext());
        }
        length--;

    }

    public String toString(){
        String result = "[";
        if(head == null){
            return result = result + "]";
        }

        result = result + head.getData();
        ListNode temp  = head.getNext();
        while(temp != null){
            result = result + "->" + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}
