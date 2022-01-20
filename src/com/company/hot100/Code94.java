package com.company.hot100;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1237 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code94 {

    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        TreeNode cur = tree;
        cur.left = null;
        cur.right = new TreeNode(2);
        cur = cur.right;
        cur.left = new TreeNode(3);
        inorderTraversal(tree);
        System.out.println(res);
        System.out.println(inorderTraversal2(tree));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while(root!=null||!stack.isEmpty()){

            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return  res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}