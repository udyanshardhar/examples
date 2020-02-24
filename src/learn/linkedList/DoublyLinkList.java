package learn.linkedList;

public class DoublyLinkList {

    private DLListNode head;
    private DLListNode tail;
    private int length;

    public int getLength(){
        return length;
    }


    public int getPosition(int data){
        int position = 0;
        DLListNode temp = head;
        while(temp != null){
            if(temp.getData() == data) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }
        return Integer.MIN_VALUE;
    }

    public DoublyLinkList(){
        head =  new DLListNode(Integer.MIN_VALUE, null, null);
        tail = new DLListNode(Integer.MIN_VALUE, head, null);
        head.setNext(tail);
        length = 0;
    }

    public void insertAtBeginning(int data){
        if(head == null){
            head = new DLListNode(data);
        }else {
            DLListNode temp = new DLListNode(data);
            temp.setNext(head);
            head.setPrevious(temp);
            head = temp;
        }
        length++;
    }

    public void insertAtEnd(int data){
        DLListNode temp = new DLListNode(data);
        if(head == null){
            head = temp;
        }else {
            DLListNode lastNode = head;
            while(lastNode.getNext() != null){
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(temp);
            temp.setPrevious(lastNode);
        }
        length++;
    }

    public void insertAtPosition(int data, int position) {

        if(position < 0){
            position = 0;
        }

        if(position > length) {
            position = length;
        }

        if(head == null){
            head = tail = new DLListNode(data);
        }else if(position == 0) {
            DLListNode temp = new DLListNode(data, null, head);
            head.setPrevious(temp);
            head = temp;
        }else {
            DLListNode temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            DLListNode newNode = new DLListNode(data);
            newNode.setNext(temp.getNext());
            temp.getNext().setPrevious(newNode);
            newNode.setPrevious(temp);
            temp.setNext(newNode);
        }
        length++;
    }

    public void removePosition(int position) {

        if(position < 0){
            position = 0;
        }

        if(position > length) {
            position = length-1;
        }

        if(head == null){
            return;
        }else if(position == 0) {
            head = head.getNext();
            head.setPrevious(null);
        }else {
            DLListNode temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }

            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
        length--;
    }

    public synchronized void removeMatched(int data) {
        DLListNode temp = head;
        if(temp == null){
            return;
        }

        while(temp != null && temp.getData() != data){
            temp = temp.getNext();
        }

        if(null != temp.getPrevious()) {
            temp.getPrevious().setNext(temp.getNext());
        }
        temp.getNext().setPrevious(temp.getPrevious());

    }

}
