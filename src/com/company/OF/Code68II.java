package com.company.OF;

/**
 * @program: code
 * @description: 二叉树的最近公共祖先.java
 * @author:
 * @create:
 **/
public class Code68II {

    //方法2
    private TreeNode res;
    private int k;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        k = 2;
        dfs(root,p,q);
        return res;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q){

        if (root == null||k==0){return;}
        int curK = k;
        if (root==p||root==q){
            k--;
        }
        dfs(root.left,q,p);
        dfs(root.right,q,p);
        if (curK==2&&k==0&&res==null){
            res = root;
        }

    }

    //递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null||root == p||root==q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if (left==null){return right;}
        if (right==null){return left;}
        return root;
    }
}
