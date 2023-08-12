package com.w6n.charpter4_stack.level2;
import java.util.Stack;

class MaxStack {
    Stack<Integer> xStack;
    Stack<Integer> maxStack;

    public MaxStack() {
        xStack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        xStack.push(x);
        maxStack.push(Math.max(x,maxStack.isEmpty()?Integer.MIN_VALUE:maxStack.peek()));
    }

    public int pop() {
        maxStack.pop();
        return xStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> buffer = new Stack<>();
        int max = peekMax();
        while (max != top()){
            buffer.push(pop());
        }
        pop();
        while (buffer.isEmpty()){
            push(buffer.pop());
        }
        return max;
    }
}
