package com.company.OF;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: code
 * @description: 二叉树的深度.java
 * @author:
 * @create:
 **/
public class Code55 {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(3);
        TreeNode cur = tree;
        cur.left = new TreeNode(9);
        cur.right = new TreeNode(20);
        cur = cur.right;
        cur.left = new TreeNode(15);
        cur.right = new TreeNode(7);
        System.out.println(maxDepth(tree));

    }

    //BFS 23 88
    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }

        return res;
    }

    //dfs 后序遍历 100 40
    public static int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    //dfs 100 35
    static int max = 0;

    public static int maxDepth1(TreeNode root) {

        if (root == null) {
            return max;
        }
        int depth = 0;
        back(root, depth);
        return max + 1;
    }

    public static void back(TreeNode root, int depth) {

        if (root.left != null) {
            back(root.left, depth + 1);
        }
        if (root.right != null) {
            back(root.right, depth + 1);
        }
        max = depth > max ? depth : max;
    }


}
