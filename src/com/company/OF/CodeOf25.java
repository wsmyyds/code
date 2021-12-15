package com.company.OF;


/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class CodeOf25 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next= new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next= new ListNode(4);
        back(l1);
        System.out.println(" ");
        back(l2);
        System.out.println(" ");

        //ListNode l3 = mergeTwoLists1(l1,l2);
        //back(l3);

//        ListNode l4 = mergeTwoLists2(l1,l2);
//        back(l4);

        ListNode l4 = mergeTwoLists3(l1,l2);
        back(l4);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }


    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val<=l2.val){
            l1.next = mergeTwoLists3(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2.next);
            return l2;
        }

    }

    /**
    * @Description: M2
    */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null;
        if (l1.val >= l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        ListNode index = head;

        while (l1!= null && l2 != null) {
            if (l1.val >= l2.val) {
                index.next = l2;
                l2 = l2.next;
                index = index.next;
            } else {
                index.next = l1;
                l1 = l1.next;
                index = index.next;
            }
        }
        if (l2 == null) {
            index.next = l1;
        }
        if (l1 == null) {
            index.next = l2;
        }
       return  head;
    }


    /**
    * @Description: M1
    */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(0);
        ListNode endList = list;

        while(l1 != null||l2 !=null){

            if (l1 == null){
                list.next = l2;
                return endList.next;
            }else if (l2 == null){
                list.next = l1;
                return endList.next;
            }
            if (l1.val <=l2.val){
                list.next = l1;
                list = list.next;
                l1 = l1.next;

            }else if (l1.val > l2.val){
                list.next = l2;
                list = list.next;
                l2 = l2.next;

            }


        }

        return endList.next;
    }

    public static void back(ListNode list){

        System.out.print(list.val+" ");
        if (list.next != null){
            back(list.next);
        }
    }


}
