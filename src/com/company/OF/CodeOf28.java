package com.company.OF;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class CodeOf28 {


    public static void main(String[] args) {

        //1, 2, 2, null, 3, null, 3
        Integer[] arr = new Integer[]{1, 2, 2, 3, 3, 3, 3};

        TreeNode root = createTree(arr);

//        System.out.println("ROOT: " + root.val + " ");
//        printTree(root);
        // printTreeByLevel(root);
        //System.out.println(levelOrder(root));
        //printTree1(root);

        System.out.println(isSymmetric(root));


    }


    //code28 判断二叉树是否对称
    public static boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return re(root.left,root.right);
        return root==null?true:re(root.left,root.right);
    }

    //code28 判断二叉树是否对称
    public static boolean re(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return  re(l.left,r.right)&&re(l.right,r.left);
    }

    //层序创建二叉树
    public static TreeNode createTree(Integer[] arr) {


        TreeNode root = new TreeNode(arr[0]);
        TreeNode cur;

        Queue<TreeNode> queueTree = new LinkedList();
        //add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false
        queueTree.offer(root);
        int i = 1;

        while (i < arr.length) {
            cur = queueTree.poll();
            if (arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                queueTree.offer(cur.left);
            }
            i++;
            if (arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                queueTree.offer(cur.right);
            }
            i++;
        }

        return root;
    }

    //层序遍历二叉树2.0 code102
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();

        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queueTree = new LinkedList();
        queueTree.offer(root);
        TreeNode cur;
        //res.add(Collections.singletonList(root.val));
        //System.out.println("ROOT: " + root.val + " ");
        while (!queueTree.isEmpty()) {
            List<Integer> elements = new ArrayList<Integer>();
            int n = queueTree.size();
            for (int i = 0; i < n; i++) {
                cur = queueTree.poll();
                elements.add(cur.val);
                if (cur.left != null) {
                    queueTree.offer(cur.left);
                    //System.out.print(cur.left.val+" ");
                    //elements.add(cur.left.val);
                }
                if (cur.right != null) {
                    queueTree.offer(cur.right);
                    //System.out.print(cur.right.val+" ");
                    //elements.add(cur.right.val);
                }
//                if (!elements.isEmpty()) {
//                    res.add(elements);
//                    elements.clear();
//                }
            }
            res.add(elements);


        }
        return res;
    }

    //层序遍历二叉树
    public static void printTreeByLevel(TreeNode root) {

        Queue<TreeNode> queueTree = new LinkedList();
        queueTree.offer(root);
        TreeNode cur;
        System.out.println("ROOT: " + root.val + " ");
        while (!queueTree.isEmpty()) {
            cur = queueTree.poll();
            if (cur.left != null) {
                queueTree.offer(cur.left);
                System.out.print(cur.left.val + " ");
            }
            if (cur.right != null) {
                queueTree.offer(cur.right);
                System.out.print(cur.right.val + " ");
            }

        }

    }


    //先序输出二叉树
    public static void printTree(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return;
        }
        if (tree.left != null) {
            System.out.print("L: " + tree.left.val + " ");
            printTree(tree.left);
        } else {
            System.out.print("L: null ");
        }
        if (tree.right != null) {
            System.out.print("R: " + tree.right.val + " ");
            printTree(tree.right);
        } else {
            System.out.print("R: null ");
        }
    }


    //dfs
    public static void printTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        printTree1(root.left);
        printTree1(root.right);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //    public TreeNode newTree(Integer[] n){
//        //数组是.length
//        int len = n.length;
//        if (len<=0){
//            return null;
//        }
//
//        TreeNode root = new TreeNode(n[0]);
//        TreeNode cur = root;
//        TreeNode nextLoc;
//        for (int i = 1; i < len; i++) {
//            if (loc==0) {
//                cur.left.val = n[i];
//                loc = 1;
//            }
//            if (loc==1){
//                cur.right.val = n[i];
//                loc = 0;
//            }
//
//        }
//        return
//    }
//
//    public TreeNode next_loc(TreeNode cur){
//
//        if (cur.right.left != null&&cur.right.left != null)
//        return
//    }

}


