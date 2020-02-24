package learn.queue;

import java.util.Stack;

public class QueueFromStack {

    public static void main(String[] args) {
        QueueFromStack queueFromStack = new QueueFromStack();
        queueFromStack.push(1);
        queueFromStack.push(2);
        queueFromStack.push(3);
        System.out.print(queueFromStack.pop().toString());
        System.out.print(queueFromStack.pop().toString());
        System.out.print(queueFromStack.pop().toString());
        System.out.print(queueFromStack.isEmpty());
        queueFromStack.push(1);
        System.out.print(queueFromStack.pop().toString());
    }

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void push(Integer x) {
        this.pushStack.push(x);
    }

    public Integer pop() {
        if(popStack.empty()){
            while(!pushStack.isEmpty()){
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.pop();
    }

    public Integer peek(){
        if(popStack.empty()){
            while(!pushStack.isEmpty()){
                this.popStack.push(this.pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean isEmpty(){
        return this.pushStack.isEmpty() && this.popStack.isEmpty();
    }


}
