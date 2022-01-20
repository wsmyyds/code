package com.company.hot100;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code21 {

    public static void main(String[] args) {
        ListNode cur;
        ListNode list1 = new ListNode(1);
        cur = list1;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        cur = list2;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);

        System.out.println(mergeTwoLists(list1, list2).toString());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(list1!=null&&list2!=null){

            if (list1.val<= list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1!=null){
            cur.next = list1;
        }
        if (list2!=null){
            cur.next = list2;
        }
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
