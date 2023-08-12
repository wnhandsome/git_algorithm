package com.w6n.charpter4_stack.level;

public class ListStack<T> {

    class Node{
        T t;
        Node next;
        public Node(T t) {
            this.t = t;
        }
    }

    //虚礼头节点
    private Node dummyNode;
    public ListStack() {
        this.dummyNode = new Node(null);
    }

    //入栈
    public void push(T t){
        Node node = new Node(t);
        node.next = dummyNode.next;
        dummyNode.next = node;
    }

    //显示栈顶元素
    public T peek(){
        T t = null;
        if (!isEmpty()){
            t = dummyNode.next.t;
        }
        return t;
    }

    //出栈
    public T pop(){
        T t = peek();
        if (!isEmpty()){
            dummyNode.next = dummyNode.next.next;
        }
        return t;
    }

    //判空
    public boolean isEmpty(){
        return dummyNode.next == null;
    }


    public static void main(String[] args) {
        ListStack stack = new ListStack();
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

}
