package com.company.OF;

/**
 * @program: code
 * @description: 删除链表的节点.java
 * @author:
 * @create:
 **/
public class Code18 {
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        //ListNode list = new ListNode(-3);
        ListNode cur = list;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(-99);
        cur = cur.next;
        cur.next = new ListNode(9);
//       cur = cur.next;
//        cur.next = new ListNode(5);

        System.out.println(deleteNode(list, 5));
    }

    //100 85
    public static ListNode deleteNode(ListNode head, int val) {

        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.next!=null&&cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    //100 72
    public static ListNode deleteNode1(ListNode head, int val) {

        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        //注意 条件是cur.next != null
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}