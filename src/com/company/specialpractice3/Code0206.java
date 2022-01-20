package com.company.specialpractice3;

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针 👍 88 👎 0


import java.util.ArrayList;

public class Code0206 {

    /***stack pop() and peek() will return stack value in the top,but pop() remove stack ,peek() not*/
    /***null | 1 | 101 is true */
    public static void main(String[] args) {

        ListNode list = new ListNode(0);
        ListNode cur = list;
        cur.next = new ListNode(0);
        cur = cur.next;
 //       cur.next = new ListNode(0);
//        cur = cur.next;
//        cur.next = new ListNode(3);
//        cur = cur.next;
//        cur.next = new ListNode(2);
//        cur = cur.next;
//        cur.next = new ListNode(1);

        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(ListNode head) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        int first = 0, end = arrayList.size() - 1;
        while (first < end) {
            if (!arrayList.get(first).equals(arrayList.get(end))) {
                return false;
            }
            first++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeAbanden(ListNode head) {

//        if (head==null){
//            return true;
//        }
//
//        ListNode fast = head;
//        ListNode slow = head;
//        int len=0;
//        while(fast != null){
//
//            if (fast.next==null){
//
//            }
//            fast = fast.next.next;
//            len++;
//            slow = slow.next;
//        }
//
//    }
//
//    public boolean back(ListNode head){
//
//        if ()
        return true;
    }

}
