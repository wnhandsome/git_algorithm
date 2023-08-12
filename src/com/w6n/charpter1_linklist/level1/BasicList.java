package com.w6n.charpter1_linklist.level1;

import java.util.List;

public class BasicList {

    public static void main(String[] args) {
        ListNode head = initLinkedList();
        printList(head);
        System.out.println(getLength(head));

        System.out.println("======测试链表插入=====");
        ListNode nodeInsert = new ListNode(-1);
        head = insertNode(head, nodeInsert, 1);
        printList(head);//-1,1,2,3,4,5

        System.out.println("\n"+"======测试链表删除=====");
        head = deleteNode(head,4);
        printList(head);//-1,1,2,4,5

        System.out.println("\n"+"======测试翻转删除=====");
        head = reverse(head);
        printList(head);
    }

    //翻转链表
    public static ListNode reverse(ListNode head){
        ListNode result = null;
        ListNode pre = null;
        while (head != null){
            pre = result;
            result = head;
            head = head.next;
            result.next = pre;
        }
        return result;
    }

    //创建一个值为1 2 3 4 5 的链表
    public static ListNode initLinkedList() {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 1; i <= 5; i++) {
            ListNode listNode = new ListNode(i);
            if (i == 1) {
                head = listNode;
                cur = listNode;
            } else {
                cur.next = listNode;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+",");
            cur = cur.next;
        }
    }

    public static int getLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    //插入节点
    public static ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {
        if (head == null) {
            return nodeInsert;
        }
        int size = getLength(head);
        if (position < 1 || position > size+1) {
            System.out.println("插入位置越界");
            return head;
        }
        //表头插入
        if (position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }
        //链表中间和结尾插入，先遍历链表,找到前驱节点
        ListNode pre = head;
        int count = 1;
        while (count < position-1){
            pre = pre.next;
            count++;
        }
        nodeInsert.next = pre.next;
        pre.next = nodeInsert;

        return head;
    }

    //删除节点
    public static ListNode deleteNode(ListNode head,int position){
        if(head == null){
            return null;
        }
        int size = getLength(head);
        if (position < 1 || size < position){
            throw new RuntimeException("删除位置越界");
        }
        //表头删除
        if (position == 1) {
            return head.next;
        }
        //链表中间和结尾删除，先遍历链表,找到前驱节点
        ListNode pre = head;
        int count = 1;
        while (count < position-1){
            pre = pre.next;
            count++;
        }
        pre.next = pre.next.next;
        return head;
    }
}


