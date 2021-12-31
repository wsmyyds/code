package com.company.OF;

import java.util.HashSet;

/**
 * @program: code
 * @description: 两个链表的第一个公共节点.java
 * @author:
 * @create:
 **/
public class Code52 {

    public static void main(String[] args) {

        ListNode list = new ListNode(8);
        ListNode cur = list;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);

        ListNode cur1;
        ListNode cur2;
        ListNode list1 = new ListNode(4);
        cur1 = list1;
        cur1.next = new ListNode(1);
        cur1 = cur1.next;
        cur1.next = list;

        ListNode list2 = new ListNode(5);
        cur2 = list2;
        cur2.next = new ListNode(0);
        cur2 = cur2.next;
        cur2.next = new ListNode(1);
        cur2 = cur2.next;
        cur2.next = list;


        System.out.println(getIntersectionNode(list1, list2));

    }

    //双指针
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode A = headA, B = headB;
        while (A != B) {
            if (A != null) {
                A = A.next;
            } else {
                A = headB;
            }
            if (B != null) {
                B = B.next;
            } else {
                B = headA;
            }
        }
        return A;

    }

    //哈希表
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> hashSet = new HashSet<>();
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            //注意 这里直接判断两个listnode地址是否相等即可，只要相等不用比较后面的node是否对应
            if(hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
