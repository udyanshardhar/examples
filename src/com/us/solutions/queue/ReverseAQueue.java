package com.us.solutions.queue;

import java.util.Stack;

public class ReverseAQueue {
    public LinkedQueue reverse(LinkedQueue queue) throws Exception {
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        return queue;
    }
}
