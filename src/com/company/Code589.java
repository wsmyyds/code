package com.company;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code589 {

    public static void main(String[] args) {

        String s = "1,null,3,2,4,null,5,6";
        //String s = "3,2,4,null,5,6,null";
        System.out.println(initNTree(s));
        Node node = initNTree(s);
        System.out.println(preorder(node));


    }

    public static List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    public static void dfs(List<Integer> res,Node node){

        if (node!=null){

            res.add(node.val);
            for (Node curNode:node.children
                 ) {
                dfs(res,curNode);
            }

        }

    }

    public static Node initNTree(String s) {

        s = s+",null";
        Queue<Node> queue = new LinkedList<>();
        System.out.println(s);
        Node res = queue.peek();
        Node cur = queue.poll();
        List<Node> childrenList = new ArrayList<>();
        for (String str :
                s.split(",")) {

            if (cur == null) {
                if (!str.equals("null")) {
                    Node newNode = new Node(Integer.parseInt(str));
                    queue.add(newNode);
                    continue;
                }else{
                    cur = queue.poll();
                    res = cur;
                    continue;
                }
            }
            //为null，切换下一个节点
            if (str.equals("null")) {
                cur.children = childrenList;
                //不能使用childrenList.clear();
                childrenList = new ArrayList<>();
                cur = queue.poll();
            } else {

                //必须为同一个对象
                Node newNode = new Node(Integer.parseInt(str));
                //构建该节点子节点
                childrenList.add(newNode);
                queue.add(newNode);

            }

        }
        return res;
    }


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
