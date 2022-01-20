package com.company.specialpractice3;

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 哈希表 链表 双指针 👍 136 👎 0

import java.util.HashSet;

public class Code0201 {

    /***hashset type add() is boolean*/
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        ListNode cur = list;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(1);

        System.out.println(removeDuplicateNodes(list));

    }

    public static ListNode removeDuplicateNodes(ListNode head) {

        if (head == null){
            return null;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        ListNode preCur = head;
        ListNode cur = head.next;
        while(cur!=null){
            if (hashSet.add(cur.val)){
                cur = cur.next;
                preCur = preCur.next;
            } else{
                cur = cur.next;
                preCur.next = cur;
            }
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