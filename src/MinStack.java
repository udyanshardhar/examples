import java.util.Stack;

public class MinStack {

    private Stack<Integer> regularStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        regularStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        this.regularStack.push(x);
        if(this.minStack.size() == 0){
            this.minStack.push(x);
        }else if(x < this.minStack.peek()){
            this.minStack.push(x);
        }
    }

    public void pop(){
        Integer pop = regularStack.pop();
        if(!regularStack .isEmpty() &&  !minStack.isEmpty() && pop.equals(this.minStack.peek())){
            this.minStack.pop();
        }
    }

    public int top(){
        return this.regularStack.peek();
    }

    public int getMin(){
        return this.minStack.peek();
    }

}
