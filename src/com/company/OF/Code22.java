package com.company.OF;

/**
 * @program: code
 * @description: 链表中倒数第k个节点.java
 * @author:
 * @create:
 **/
public class Code22 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode cur = list;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        System.out.println(list);

        System.out.println(getKthFromEnd(list, 2));

    }

    //双指针，快慢指针
    public static ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
           fast = fast.next;
           slow = slow.next;
        }
        return slow;
    }

    //100 68
    public static ListNode getKthFromEnd(ListNode head, int k) {

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (len > k) {
            //当len>k时减才能获取到，<=k时直接返回
            len = len - k;
            while (len != 0) {
                head = head.next;
                len--;
            }
        }

        return head;

    }
}


