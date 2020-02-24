package learn.linkedList;

public class CLLNode {
    private int data;
    private CLLNode Next;

    public CLLNode(int data, CLLNode previous, CLLNode next) {
        this.data = data;
        Next = next;
    }

    public CLLNode(int data) {
        this(data, null, null);
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    public CLLNode getNext() {
        return Next;
    }

    public void setNext(CLLNode next) {
        Next = next;
    }
}
