package com.us.solutions.queue;

public class MyCircularQueue {
    private int [] data;
    private int rear, front;
    private int length;
    public MyCircularQueue(int length) {
     this.data = new int[length];
     this.length = length;
     this.rear = 0;
     this.front = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(rear == length -1)
            return false;
        data[front] = value;
        rear++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        return false;
    }

}
