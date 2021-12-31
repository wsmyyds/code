package com.company.OF;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: code
 * @description: 二叉搜索树的第k大节点.java
 * @author:
 * @create: 注意：
 * 二叉搜索树（又 二叉查找树/二叉排序数）
 * 当左子树不为空，左子树上节点值均小于根节点值
 * 当右子树不为空，右子树上节点值均小于根节点值
 * 任意左/右子树都是二叉搜索树
 * ---->中序遍历是一个递增数列
 * 3
 * / \
 * 1   5
 * / \ / \
 * 0  2 4  6
 **/
public class Code54 {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(3);
        TreeNode cur = tree;
        cur.left = new TreeNode(1);
        cur.right = new TreeNode(4);
        cur.left.right = new TreeNode(2);

        int target = 1;
        System.out.println(kthLargest(tree, target));
    }

    static int res, z;

    public static int kthLargest(TreeNode root, int k) {

        z = k;
        back(root);
        return res;

    }

    //100 84
    public static void back(TreeNode root) {
        
        if (root != null) {
            if (z==0){
                return;
            }
            back(root.right);
            z--;
            //简写 if(--z=0)
            if (z==0){
                res = root.val;
            }
            back(root.left);

        }
    }

    //7 5 qaq
    public static int kthLargest1(TreeNode root, int k) {

        ArrayList list = new ArrayList();
        back(root, list);
        Object[] res = list.toArray();
        Arrays.sort(res);
        return (int) res[res.length - k];

    }

    public static void back(TreeNode root, ArrayList list) {
        if (root != null) {
            //这个-
            back(root.left, list);
            //顺序-
            back(root.right, list);
            //表示二叉树是那种遍历方式
            list.add(root.val);
        }
    }

}


