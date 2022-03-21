package com.company;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code653 {

    public static void main(String[] args) {

        //获取类的修饰符
        System.out.println(Modifier.isPublic(BinarySearchTree.class.getModifiers()));
        int[] arr = new int[]{5,3,6,2,4,-1,7};
        BinarySearchTree bst = BinarySearchTree.getInitBinarySearchTreeByArray(arr);
        System.out.println(findTarget(bst,9));


    }

    public static boolean findTarget(BinarySearchTree root, int k) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        return dfs(root,hashMap,k);

    }

    public static boolean dfs(BinarySearchTree root, HashMap<Integer,Integer> hashMap,int k){

        if (root == null){
            return false;
        }
        if (hashMap.containsKey(k- root.val)){
            return true;
        }
        hashMap.put(root.val,null);
        //这样写可以直接在递归的任意位置跳出
        //如果方法为void，return则不行
        return dfs(root.left,hashMap,k)||dfs(root.right,hashMap,k);
    }

}

class BinarySearchTree {

    int val;
    BinarySearchTree left;
    BinarySearchTree right;

    BinarySearchTree() {
    }

    BinarySearchTree(int val) {
        this.val = val;
    }

    BinarySearchTree(int val, BinarySearchTree left, BinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据数组层次创建BST，arr[i]>=0,空节点用-1表示
     * e.g. root = [5,3,6,2,4,null,7]
     * arr = [5,3,6,2,4,-1,7]
     *         5
     *       /  \
     *      3    6
     *     / \  /  \
     *    2  4 null 7
     * */
    public static BinarySearchTree getInitBinarySearchTreeByArray(int[] arr){

        if (arr.length<1){
            return new BinarySearchTree();
        }
        //构建先进先出队列
        Queue<BinarySearchTree> initBinarySearchTreeQueue = new LinkedList<>();
        //初始化root节点
        BinarySearchTree binarySearchTree = new BinarySearchTree(arr[0]);
        initBinarySearchTreeQueue.add(binarySearchTree);
        int arrIndex = 1;
        while(!initBinarySearchTreeQueue.isEmpty()&&arrIndex<arr.length){

            BinarySearchTree curNode = initBinarySearchTreeQueue.poll();
            if (arr[arrIndex]!=-1){
                curNode.left = new BinarySearchTree(arr[arrIndex++]);
            }else {
                arrIndex++;
            }
            if (arr[arrIndex]!=-1){
                curNode.right = new BinarySearchTree(arr[arrIndex++]);
            }else {
                arrIndex++;
            }
            if (curNode.left!=null){
                initBinarySearchTreeQueue.add(curNode.left);
            }
            if (curNode.right!=null){
                initBinarySearchTreeQueue.add(curNode.right);
            }
        }
        return binarySearchTree;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
