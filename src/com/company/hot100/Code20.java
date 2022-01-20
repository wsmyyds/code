package com.company.hot100;

import java.util.Stack;

/**
 * @program: code
 * @description: 有效的括号.java
 * @author:
 * @create:
 **/
public class Code20 {

    public static void main(String[] args) {

        String str = "()[]{}";
        //String str = "(]";
        //String str = "([)]";
        //String str = "{[]}";
        //String str = "{";
        //String str = "}";
        System.out.println(isValid(str));

    }

    //优化结构 98 76
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char curChar : s.toCharArray()) {
            if (curChar == '(') {
                stack.push(')');
                continue;
            }
            if (curChar == '[') {
                stack.push(']');
                continue;
            }
            if (curChar == '{') {
                stack.push('}');
                continue;
            }
            if (stack.isEmpty()||curChar!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    //98 97
    public static boolean isValid1(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '[' || curChar == '{') {
                stack.push(curChar);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (curChar == ')' && stack.pop() != '(') {
                return false;
            }
            if (curChar == ']' && stack.pop() != '[') {
                return false;
            }
            if (curChar == '}' && stack.pop() != '{') {
                return false;
            }
        }
//        if (!stack.isEmpty()) {
//            return false;
//        }
        return stack.isEmpty();

    }

    //错误解法
    public static boolean isValidOut(String s) {

        int[] arr = new int[3];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    arr[0] = ++arr[0];
                    break;
                case ')':
                    if (arr[1] != 0 || arr[2] != 0) {
                        return false;
                    }
                    arr[0] = --arr[0];
                    break;
                case '[':
                    arr[1] = ++arr[1];
                    break;
                case ']':
                    if (arr[0] != 0 || arr[2] != 0) {
                        return false;
                    }
                    arr[1] = --arr[1];
                    break;
                case '{':
                    arr[2] = ++arr[2];
                    break;
                case '}':
                    if (arr[0] != 0 || arr[1] != 0) {
                        return false;
                    }
                    arr[2] = --arr[2];
                    break;
                default:
            }
        }
        return true;
    }
}
