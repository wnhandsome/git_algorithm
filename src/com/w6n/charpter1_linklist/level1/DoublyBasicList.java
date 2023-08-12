package com.w6n.charpter1_linklist.level1;

public class DoublyBasicList {
    private DoublyNode first;
    private DoublyNode last;

    public DoublyBasicList() {
        first = null;
        last = null;
    }

    public static void main(String[] args) {
        DoublyBasicList doublyBasicList = new DoublyBasicList();

        doublyBasicList.insertLast(10);
        doublyBasicList.insertLast(20);
        doublyBasicList.insertLast(30);
        doublyBasicList.insertLast(40);
        doublyBasicList.insertLast(50);
        doublyBasicList.displayForward();//10,20,30,40,50,

        doublyBasicList.insertAfter(20,-1);
        doublyBasicList.displayForward();//10,20,-1,30,40,50,

        doublyBasicList.deleteFirst();
        doublyBasicList.displayForward();//20,-1,30,40,50,

        doublyBasicList.deleteLast();
        doublyBasicList.displayForward();//20,-1,30,40,

        doublyBasicList.deleteKey(-1);
        doublyBasicList.displayForward();//20,30,40,
    }

    //从头部开始打印
    public void displayForward() {
        System.out.println("===== first=>last ====");
        DoublyNode cur = first;
        while (cur != null){
            System.out.print(cur.data+",");
            cur = cur.next;
        }
        System.out.println();
    }

    //从尾部开始打印
    public void displayBackward(){
        System.out.println("===== last=>first ====");
        DoublyNode cur = last;
        while (cur != null){
            System.out.print(cur.data+",");
            cur = cur.prev;
        }
        System.out.println();
    }

    //头部插入
    public void insertFirst(int data){
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()){
            last = newNode;
        }else {
            first.prev = newNode;
            newNode.next = first;
        }
        first = newNode;
    }

    //尾部插入
    public void insertLast(int data){
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()){
            first = newNode;
        }else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
    }

    //某个结点的后部插入
    public void insertAfter(int key,int data){
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode cur = first;
        while (cur!=null && cur.data!=key){
            cur = cur.next;
        }
        if(cur == null){    //即没有找到key,就在尾部插入新节点
            this.insertLast(data);
        }else {     //找到key
            if (cur == last){
                last = newNode;
            }else {
                cur.next.prev = newNode;
                newNode.next = cur.next;
            }
            newNode.prev = cur;
            cur.next = newNode;
        }
    }

    //删除首元素,返回删除的元素值
    public DoublyNode deleteFirst(){
        DoublyNode temp = first;
        if (isEmpty()){
            throw new RuntimeException("双链表中没有元素");
        }else {
            if (first.next == null){
                last = null;
            }else {
                first.next.prev = null;
            }
            first = first.next;
        }
        return temp;
    }

    //删除尾元素,返回删除的元素值
    public DoublyNode deleteLast(){
        DoublyNode temp = last;
        if (isEmpty()){
            throw new RuntimeException("双链表中没有元素");
        }else{
            if(last.prev == null){
                first = null;
            }else {
                last.prev.next = null;
            }
            last = last.prev;
        }
        return temp;
    }

    //根据指定值删除元素,返回删除的元素值
    public DoublyNode deleteKey(int key){
        DoublyNode cur = first;
        while (cur!=null && cur.data!=key){
            cur = cur.next;
        }
        if(cur == null){
            return null;
        }else {
            if(cur == first){
                deleteFirst();
            } else if (cur == last) {
                deleteLast();
            } else {
              cur.prev.next = cur.next;
              cur.next.prev = cur.prev;
            }
        }
        return cur;
    }

    //判断双向链表是否有元素
    public boolean isEmpty(){
        return first==null;
    }


}
