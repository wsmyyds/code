package com.company.OF;

/**
 * @program: code
 * @description: 二叉搜索树的最近公共祖先.java
 * @author:
 * @create:
 **/
public class Code68 {

    public static void main(String[] args) {

    }

    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur;
    }

    //递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
