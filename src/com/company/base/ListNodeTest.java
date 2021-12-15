package com.company.base;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class ListNodeTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        //存储list的head
        ListNode list1 = list;
        for (int i = 0; i <5;i++){
            list.next =  new ListNode(i);
            list =list.next;
        }
        back(list1);

//        System.out.println(list.val);
//        list.next = new ListNode(2);
//        list = list.next;
//        System.out.println(list.val);
    }

    //输出ListNode
    public static void back(ListNode list){

        System.out.print(list.val+" ");
        if (list.next != null){
            back(list.next);
        }
    }
}
