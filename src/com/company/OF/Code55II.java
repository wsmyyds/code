package com.company.OF;

/**
 * @program: code
 * @description: 平衡二叉树.java
 * @author:
 * @create:
 **/
//todo 未解决
public class Code55II {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        TreeNode cur = tree;
        cur.left = new TreeNode(9);
        cur.right = new TreeNode(20);
        cur = cur.right;
        cur.left = new TreeNode(15);
        cur.right = new TreeNode(7);
        System.out.println(isBalanced(tree));
    }

    public static boolean isBalanced(TreeNode root) {

        return back(root) != -1;

    }

    public static int back(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = back(root.left);
        if (left == -1) {
            return -1;
        }
        int right = back(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
