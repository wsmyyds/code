package com.company.P1;

import java.util.Stack;

/**
 * @program: code
 * @description:[09]用两个栈实现队列
 * @author:
 * @create:
 **/
public class Code09 {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

}

class CQueue {

    Stack<Integer> stack1,stack2;

    public CQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {

        stack1.push(value);

    }

    public int deleteHead() {

        if (!stack2.isEmpty()){

            return stack2.pop();
        }
        if (stack1.isEmpty()){
            return -1;
        }

        //int len = stack1.size();
        //for (int i = 0; i < len ; i++) {
        for (int i = stack1.size()-1; i >=0 ; i--) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }
}