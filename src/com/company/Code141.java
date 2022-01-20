package com.company;
//给你一个链表的头节点 head ，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 10⁴]
// -10⁵ <= Node.val <= 10⁵
// pos 为 -1 或者链表中的一个 有效索引 。
//
//
//
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
// Related Topics 哈希表 链表 双指针 👍 1321 👎 0


import java.util.HashSet;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code141 {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(3);
        ListNode cur = list1;
        cur.next = new ListNode(2);
        cur = cur.next;
        ListNode cycle = cur;
        cur.next = new ListNode(0);
        cur = cur.next;
        cur.next = new ListNode(-4);
        cur = cur.next;
        cur.next = cycle;
        System.out.println(hasCycle(list1));
    }

    //双指针,Floyd算法,当slow，fast相遇，fast至少多一圈
    public static boolean hasCycle(ListNode head) {

        if (head==null){
            return false;
        }
        //不能都设置为head，如只有一个数
        ListNode fast = head.next;
        ListNode slow = head;
        //fast.next解决fast = fast.next.next空指针，slow不会先为null
        while(fast!=null&&fast.next!=null){
            if (fast==slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    //hash表
    public static boolean hasCycle1(ListNode head) {

        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.add(head)){
               return true;
            }
            head = head.next;
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}