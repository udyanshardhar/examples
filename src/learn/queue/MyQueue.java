package learn.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private List<Integer> data;
    private int firstElementIndex;

    public MyQueue(){
        this.data = new ArrayList<>();
        this.firstElementIndex = 0;
    }

    public boolean enQueue(int element) {
        data.add(element);
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;

        firstElementIndex++;
        return true;
    }

    public int pop(){
        return data.get(firstElementIndex);
    }

    public boolean isEmpty() {
        return firstElementIndex >= data.size();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        q.enQueue(6);
        if (!q.isEmpty()) {
            System.out.println(q.pop());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.pop());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.pop());
        }
    }
}
