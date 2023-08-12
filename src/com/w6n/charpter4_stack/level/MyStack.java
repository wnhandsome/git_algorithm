package com.w6n.charpter4_stack.level;

import java.util.Arrays;
import java.util.Stack;

public class MyStack<T> {
    //实现栈的数组
    private Object[] stack;
    //指向栈顶的上面一个位置 也表示栈的数量
    private int top;

    //初始化栈，初始容量是10
    public MyStack(){
        stack = new Object[10];
    }

    //入栈
    public void push(T t) {
        expandCapacity(top + 1);
        stack[top] = t;
        top++;
    }

    //显示栈顶元素
    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[top - 1];
        }
        return t;
    }

    //出栈
    public T pop() {
        T t = peek();
        if (top > 0) {
            top--;
            stack[top] = null;
        }
        return t;
    }

    //判空
    public boolean isEmpty() {
        return top == 0;
    }

    //扩大容量
    private void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;  //扩容1.5倍
            Arrays.copyOf(stack, size);
        }
    }


    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

    }
}
