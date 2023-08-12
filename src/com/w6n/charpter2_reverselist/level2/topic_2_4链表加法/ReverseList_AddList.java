package com.w6n.charpter2_reverselist.level2.topic_2_4链表加法;

import java.util.List;
import java.util.Stack;

public class ReverseList_AddList {
    public static void main(String[] args) {
        int[] a = {9, 3, 7};
        ListNode nodeA = initLinkedList(a);
        int[] b = {6, 3};
        ListNode nodeB = initLinkedList(b);

        ListNode d = null;
        int testMethod = 3;
        switch (testMethod) {
            case 1://方法1：通过栈实现
                d = addInListByStack(nodeA, nodeB);
                break;
            case 2://方法2：通过链表反转来实现
                d = addInListByReverse(nodeA, nodeB);
                break;
            case 3:
                d = addInListByReverseByWn(nodeA,nodeB);
                break;

        }


        System.out.println(toString(d));

    }

    /**
     * 通过栈来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByStack(ListNode head1, ListNode head2) {
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        while (head1 != null) {
            st1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            st2.push(head2);
            head2 = head2.next;
        }
        ListNode newHead = new ListNode(-1);
        int carry = 0;
        //这里设置carry!=0,是因为当st1,st2都遍历完时，如果carry=0,就不需要进入循环了
        while (!st1.empty() || !st2.empty() || carry != 0) {
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            if (!st1.empty()) {
                a = st1.pop();
            }
            if (!st2.empty()) {
                b = st2.pop();
            }
            //每次的和应该是对应位相加再加上进位
            int get_sum = a.val + b.val + carry;
            //对累加的结果取余
            int ans = get_sum % 10;
            //如果大于0，就进位
            carry = get_sum / 10;
            ListNode cur = new ListNode(ans);
            cur.next = newHead.next;
            //每次把最新得到的节点更新到neHead.next中
            newHead.next = cur;
        }
        return newHead.next;
    }

    //通过链表反转来实现
    public static ListNode addInListByReverseByWn(ListNode l1, ListNode l2){
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode res = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            int digit = sum%10;
            ListNode cur = new ListNode(digit);
            cur.next = res;
            res = cur;
        }
        if(carry > 0){
            ListNode cur = new ListNode(carry);
            cur.next = res;
            res = cur;
        }
        return res;
    }

    /**
     * 方法2：通过链表反转来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByReverse(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val = carry;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
