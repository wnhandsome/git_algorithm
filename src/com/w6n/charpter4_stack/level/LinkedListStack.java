package com.w6n.charpter4_stack.level;

import java.util.LinkedList;

public class LinkedListStack<T> {

    private LinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    //入栈
    public void push(T t){
        linkedList.addFirst(t);
    }

    //显示栈顶元素
    public T peek(){
        return linkedList.peekFirst();
    }

    //出栈
    public T pop(){
        return linkedList.removeFirst();
    }

    //判空
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }


    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

}
