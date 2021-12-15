package com.company.P1;

import java.util.Stack;

/**
 * @program: code
 * @description: [30]包含min函数的栈
 * @author:
 * @create:
 **/
public class Code30 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

}

//94 96
class MinStack {

    Stack<Integer> stack, stackMin;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        //x <= stackMin.peek()可以是相同小
        if (stackMin.isEmpty() || x <= stackMin.peek()) {
            stackMin.push(x);
        }
    }

    public void pop() {

        if (stackMin.peek().equals(stack.pop())) {

            stackMin.pop();
        }

    }

    public int top() {

        return stack.peek();

    }

    public int min() {

        return stackMin.peek();
    }

}

//94 99
class MinStackO {

    Stack<Integer> stack;

    //int minNum = Integer.MAX_VALUE;

    Integer minNum;

    /**
     * initialize your data structure here.
     */
    public MinStackO() {

        stack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        if (minNum == null || x < minNum) {
            minNum = x;
        }
    }

    public void pop() {

        if (stack.pop().equals(minNum)) {
            if (stack.isEmpty()) {
                minNum = null;
                return;
            }
            minNum = top();
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (minNum > stack.get(i)) {
                    minNum = stack.get(i);
                }
            }
        }
    }

    public int top() {

        return stack.get(stack.size() - 1);
    }

    public int min() {

        return minNum;
    }

}

//5,77
class MinStackOld {
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStackOld() {

        stack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
    }

    public void pop() {

        stack.pop();
    }

    public int top() {

        return stack.get(stack.size() - 1);
    }

    public int min() {

        int res = top();
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (res > stack.get(i)) {
                res = stack.get(i);
            }
        }
        return res;
    }
}