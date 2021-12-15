package com.company.OF;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class CodeOf27 {

    public static void main(String[] args) {

        TreeNode tree = treeInit();
        System.out.println(tree.val);
        printTree(tree);

        System.out.println("  ");
        mirrorTree(tree);
        printTree(tree);

    }

    public static TreeNode mirrorTree(TreeNode root) {

        if(root == null){
            return root;
        }
        TreeNode temp;
        if (root.left == null&&root.right == null){
            return root;
        }
        temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;

        return root;

    }

    /**
    * @Description:  Definition for a binary tree node.
    */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode treeInit(){

        TreeNode tree1 = new TreeNode(4);
        TreeNode cur1 = tree1;
        addNode(cur1,2);
        addNode(cur1,7);
        addNode(cur1.left,1);
        addNode(cur1.left,3);
        addNode(cur1.right,6);
        addNode(cur1.right,9);
        return tree1;

    }

    public static void addNode(TreeNode tree, int val){
        if (tree.left==null){
            tree.left = new TreeNode(val);
            return;
        }
        if(tree.right==null){
            tree.right = new TreeNode(val);
        }

    }

    public static void printTree(TreeNode tree){
        if (tree.left == null&&tree.right == null){
            return;
        }
        if (tree.left != null){
            System.out.print("l: "+tree.left.val+" ");
            printTree(tree.left);
        }
        if (tree.right != null){
            System.out.print("r: "+tree.right.val+" ");
            printTree(tree.right);
        }

    }


}
