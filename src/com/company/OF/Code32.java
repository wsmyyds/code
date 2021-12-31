package com.company.OF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: code
 * @description: 从上到下打印二叉树 II.java
 * @author:
 * @create:
 **/
public class Code32 {

    public static void main(String[] args) {

        //[3,9,20,null,null,15,7]
        TreeNode tree = new TreeNode(3);
        TreeNode cur = tree;
        cur.left = new TreeNode(9);
        cur.right = new TreeNode(20);
        cur = cur.right;
        cur.left = new TreeNode(15);
        cur.right = new TreeNode(7);
        System.out.println(levelOrder(tree));

    }

    //dfs 100 42
    //{
    static List<List<Integer>> resList = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        resList.add(new ArrayList<>());
        back(root, 0);
        return resList;
    }

    public static void back(TreeNode node, int level) {

        if (node != null) {
            if (resList.size() <= level) {
                resList.add(new ArrayList<>());
            }

            resList.get(level).add(node.val);
            back(node.left, level + 1);
            back(node.right, level + 1);
        }

    }
    //}

    //bfs 96 77
    public static List<List<Integer>> levelOrder1(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> listNode = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                listNode.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            resList.add(listNode);

        }

        return resList;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}