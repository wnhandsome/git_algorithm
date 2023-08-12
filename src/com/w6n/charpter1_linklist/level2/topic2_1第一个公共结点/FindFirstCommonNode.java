package com.w6n.charpter1_linklist.level2.topic2_1第一个公共结点;


import com.w6n.charpter1_linklist.level1.ListNode;

import java.util.HashSet;
import java.util.Stack;

public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode[] heads = initLinkedList();
        //la 为 1 2 3 4 5
        //lb 为 11 22 4 5
        ListNode la = heads[0];
        ListNode lb = heads[1];

        int testMethod = 5;
        ListNode node = new ListNode(0);
        switch (testMethod) {
            case 1: //方法1：通过Hash辅助查找
                node = findFirstCommonNodeByMap(la, lb);
                break;
            case 2: //方法2：通过集合辅助查找
                node = findFirstCommonNodeBySet(la, lb);
                break;
            case 3://方法3：通过栈辅助查找
                node = findFirstCommonNodeByStack(la, lb);
                break;
            case 4://方法4：通过拼接辅助查找
                node = findFirstCommonNodeByCombine(la, lb);
                break;
            case 5://方法5：通过差辅助查找
                node = findFirstCommonNodeBySub(la, lb);
                break;
        }
        System.out.println("公共结点为：" + node.val);

    }

    public static ListNode findFirstCommonNodeBySub(ListNode la, ListNode lb) {
        if (la == null || lb == null) {
            return null;
        }
        int countA = 0, countB = 0;
        ListNode pa = la, pb = lb;
        while (pa != null) {
            countA++;
            pa = pa.next;
        }
        while (pb != null) {
            countB++;
            pb = pb.next;
        }
        pa = la;
        pb = lb;
        if (countB > countA) {  //如果b长，a和b就交换，使a长
            pa = lb;
            pb = la;
        }
        //规定a比b长
        for (int i = 0; i < countA - countB; i++) {
            pa = pa.next;
        }
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }

    private static ListNode findFirstCommonNodeByCombine(ListNode la, ListNode lb) {
        if (la == null || lb == null) {
            return null;
        }
        ListNode pa = la;
        ListNode pb = lb;
        ListNode result = pa;
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
            if (pa != pb) {
                if (pa == null) {
                    pa = lb;
                }
                if (pb == null) {
                    pb = la;
                }
            } else {
                result = pa;
            }
        }
        return result;
    }

    private static ListNode findFirstCommonNodeByStack(ListNode la, ListNode lb) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (la != null) {
            stack1.push(la);
            la = la.next;
        }
        while (lb != null) {
            stack2.push(lb);
            lb = lb.next;
        }
        ListNode commonNode = null;
        while (stack1.size() > 0 && stack2.size() > 0) {
            if (stack1.peek() == stack2.peek()) {
                commonNode = stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return commonNode;
    }

    public static ListNode findFirstCommonNodeBySet(ListNode la, ListNode lb) {
        HashSet<ListNode> set = new HashSet<>();
        while (la != null) {
            set.add(la);
            la = la.next;
        }
        while (lb != null) {
            if (set.contains(lb)) {
                return lb;
            }
            lb = lb.next;
        }
        return null;
    }

    public static ListNode findFirstCommonNodeByMap(ListNode la, ListNode lb) {
        return null;
    }


    /**
     * 简单构造两个链表
     *
     * @return
     */
    private static ListNode[] initLinkedList() {
        ListNode[] heads = new ListNode[2];
//        构造第一个链表交点之前的元素 1 ->2-> 3
        heads[0] = new ListNode(1);
        ListNode current1 = heads[0];
        current1.next = new ListNode(2);
        current1 = current1.next;
        current1.next = new ListNode(3);
        current1 = current1.next;
//        11->22
//        构造第二个链表交点之前的元素
        heads[1] = new ListNode(11);
        ListNode current2 = heads[1];
        current2.next = new ListNode(22);
        current2 = current2.next;
//        构造公共交点以及之后的元素

        ListNode node4 = new ListNode(4);
        current1.next = node4;
        current2.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;


        ListNode node6 = new ListNode(6);
        node5.next = node6;

        return heads;
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
