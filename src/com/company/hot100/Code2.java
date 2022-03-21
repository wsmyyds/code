package com.company.hot100;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 7648 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code2 {

    public static void main(String[] args) {

//        String str1 = "2,4,3";
//        String str2 = "5,6,4";
        String str1 = "9,9,9,9,9,9,9";
        String str2 = "9,9,9,9";
//        String str1 = "5";
//        String str2 = "5";
        Code2 code = new Code2();
        ListNode l1 = code.strConvertToList(str1);
        ListNode l2 = code.strConvertToList(str2);
        addTwoNumbers(l1,l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1==null||l2==null){
            if (l1==null){
                return l2;
            }
            return l1;
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        int temp = 0;
        while(l1!=null&&l2!=null){

            //最大9+9+1=19
            int curNum = l1.val+ l2.val+temp;
            cur.next = new ListNode(curNum%10);
            if(curNum%10!=curNum){
                temp = 1;
            }else{
                temp = 0;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null){
            while(temp!=0){
                if (l1==null){
                    cur.next = new ListNode(temp);
                    cur = cur.next;
                    break;
                }
                int curNum = l1.val+temp;
                cur.next = new ListNode(curNum%10);
                if(curNum%10!=curNum){
                    temp = 1;
                }else{
                    temp = 0;
                }
                cur = cur.next;
                l1 = l1.next;
            }
            temp = 0;
            cur.next = l1;
        }
        if (l2!=null){
            while(temp!=0){
                if (l2==null){
                    cur.next = new ListNode(temp);
                    cur = cur.next;
                    break;
                }
                int curNum = l2.val+temp;
                cur.next = new ListNode(curNum%10);
                if(curNum%10!=curNum){
                    temp = 1;
                }else{
                    temp = 0;
                }
                cur = cur.next;
                l2 = l2.next;
            }
            temp = 0;
            cur.next = l2;
        }
        if (temp!=0){
            cur.next = new ListNode(temp);
        }
        return res.next;
    }

    public  ListNode strConvertToList(String str) {

        String[] strArray = str.split(",");
        ListNode resList = new ListNode();
        ListNode cur = resList;
        for (String i:
             strArray) {
            cur.next = new ListNode(Integer.valueOf(i));
            cur = cur.next;
        }
        System.out.println("------");
        cur = resList.next;
        while(cur!=null){
            System.out.print(cur.val);
            cur= cur.next;
        }
        System.out.println();
        System.out.println("------");
        return resList.next;
    }

    public static class ListNode {
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
}
