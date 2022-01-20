package com.company;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
//输入：x = -101
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学 👍 1762 👎 0

import java.util.Arrays;

/**
 * @program: code
 * @description: [9]回文数
 * @author:
 * @create:
 **/
public class Code9 {

    public static void main(String[] args) {

        System.out.println(isPalindrome1(6));

    }

    public static boolean isPalindrome(int x) {

        char[] a = String.valueOf(x).toCharArray();
        int i = 0, j = a.length - 1;
        while (i<j){
            if (a[i]!=a[j]){
                return false;
            }
            i++;
            j--;

        }
        return true;

    }

    public static boolean isPalindrome1(int x) {

        if (x<0){
            return false;
        }
        int reX = 0;
        int originX = x;
        while(x>=10){
            reX = reX*10+x%10;
            x=x/10;
        }
        if (x>0){
            reX = reX*10+x;
        }

        return reX == originX;
    }

}
