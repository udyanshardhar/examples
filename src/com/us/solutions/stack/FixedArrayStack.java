package com.us.solutions.stack;

public class FixedArrayStack {

    public static final int CAPACITY = 10;

    protected int capacity;

    private int[] stack;

    protected int top = -1;


    public FixedArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public FixedArrayStack() {
        this(CAPACITY);
    }

    public  int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public void push(int data) throws Exception{
        if(size() == capacity){
            throw new Exception("Stack is full");
        }
        stack[++top] = data;
    }

    public int top() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        return stack[top];
    }

    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        int value = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        return value;
    }
}
