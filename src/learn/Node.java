package learn;

public class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public boolean equals(Object obj) {

        if(obj instanceof Node && ((Node) obj).data == this.data) {
            return true;
        }
        return false;
    }
}
