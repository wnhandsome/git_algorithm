package com.w6n.charpter2_reverselist;

public class Challenge {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        ListNode head = initLinkedList(arr);
        System.out.println(toString(head));

        System.out.println("变化后的结果如下：");
        System.out.println(toString(help(head)));
    }

    private static ListNode help(ListNode head){
        ListNode cur = head;
        ListNode t1 = new ListNode();
        ListNode odd = t1;
        ListNode t2 = new ListNode();
        ListNode even = t2;
        while (cur != null && cur.next != null){
            t1.next = cur;
            t2.next = cur.next;
            t1 = t1.next;
            t2 = t2.next;
            cur = cur.next.next;
        }
        if (size(head)%2==0){
            t1.next = null;
        }else {
            t1.next = t2.next;
            t2.next = null;
        }
        odd = odd.next;
        even = even.next;

        even = reverse(even);
        ListNode dummy = new ListNode();
        ListNode t = dummy;
        while (odd != null && even != null){
            t.next = odd;
            odd = odd.next;
            t.next.next = even;
            even = even.next;
            t = t.next.next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode res = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
        }
        return res;
    }

    public static int size(ListNode head){
        int size = 0;
        while (head != null){
            head = head.next;
            size++;
        }
        return size;
    }


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
        public ListNode() {
        }
    }

}
