package com.w6n.charpter4_stack.level2;

import com.w6n.charpter4_stack.level.LinkedListStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {

    Stack<Integer> xStack;
    Stack<Integer> minStack;

    public MinStack() {
        xStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
