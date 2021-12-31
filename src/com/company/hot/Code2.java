package com.company.hot;

/**
 * @program: code
 * @description: [2]两数相加.java
 * @author:
 * @create:
 **/
public class Code2 {

    public static void main(String[] args) {

        ListNode num1 = new ListNode(2);
        ListNode cur1 = num1;
        cur1.next = new ListNode(4);
        cur1 = cur1.next;
        cur1.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        ListNode cur2 = num2;
        cur2.next = new ListNode(6);
        cur2 = cur2.next;
        cur2.next = new ListNode(4);
        System.out.println(10%10);
        System.out.println(10/10);
        addTwoNumbers(num1,num2);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        back(l1,l2,0);
        System.out.println(l1.toString());
        return l1;
    }

    public static ListNode back(ListNode l1, ListNode l2,int next) {

        if (l1 == null&&l2 == null&&next==0){return null;}
        if (l1 != null) {
            l1 = l1.next;
        }else if (l1 == null) {

        }
        if (l2 != null) {
            l2 = l2.next;
        }
        return back(l1, l2,next);
    }


    public static ListNode backbad(ListNode l1, ListNode l2,int next) {

        //无法最后进位
        if (l1 == null) {
            l1 = l2;
            return l1;
        }
        if (l2 == null) {

            return l1;
        }
        int num = (l1.val+ l2.val)/10;
        l1.val = (l1.val+ l2.val)%10+next;
        return back(l1.next, l2.next,num);
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
}