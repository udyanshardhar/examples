package learn.linkedList;

public class DLListNode {
    private int data;
    private DLListNode previous;
    private DLListNode Next;

    public DLListNode(int data) {
        this.data = data;
        this.previous = null;
        this.Next = null;
    }

    public DLListNode(int data, DLListNode previous, DLListNode next) {
        this.data = data;
        this.previous = previous;
        this.Next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLListNode previous) {
        this.previous = previous;
    }

    public DLListNode getNext() {
        return Next;
    }

    public void setNext(DLListNode next) {
        Next = next;
    }
}
