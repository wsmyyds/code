package com.company;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
//
//
// 示例 1:
//
//
//输入: s = "aba"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
//
//
// 示例 3:
//
//
//输入: s = "abc"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length <= 10⁵
// s 由小写英文字母组成
//
// Related Topics 贪心 双指针 字符串 👍 449 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code680 {

    public static void main(String[] args) {

        String s = "abcddcba";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        int index1 = 0, index2 = s.length() - 1;
        char[] arr = s.toCharArray();
        while (index1 < index2) {

            if (arr[index1] != arr[index2]) {
                return removeOne(arr,index1+1,index2)||removeOne(arr,index1,index2-1);
            }
            index1++;
            index2--;
        }
        return true;
    }

    //移除一次后继续判断
    public static boolean removeOne(char[] arr, int index1, int index2) {

        while (index1 < index2) {
            if (arr[index1] != arr[index2]) {
                return false;
            }
            index1++;
            index2--;
        }
        return true;
    }

    //abcddcba 8
    //abcdcba 7

    public static boolean validPalindromeFaile(String s) {

        char[] arr = s.toCharArray();
        boolean canBeDelete = true;
        int len = arr.length;
        int index1, index2;
        if (len % 2 == 0) {
            index2 = arr.length / 2 - 1;
            index1 = index2 + 1;
        } else {
            index2 = arr.length / 2;
            index1 = index2;
        }

        while (index1 >= 0 && index2 < len) {
            if (arr[index1] == arr[index2]) {
                index1--;
                index2++;
            } else {
                if (!canBeDelete) {
//                    return false;
                    break;
                } else {
                    index1--;
                    //index2++;
                }
            }
        }
        if (index1 == -1 && index2 == len) {
            return true;
        }
        if (len % 2 == 0) {
            index2 = arr.length / 2 + 1;
        } else {
            index2 = arr.length / 2;
        }
        index1 = index2;
        while (index1 >= 0 && index2 < len) {
            if (arr[index1] == arr[index2]) {
                index1--;
                index2++;
            } else {
                if (!canBeDelete) {
                    return false;
                } else {
                    //index1--;
                    index2++;
                }
            }
        }
        if (index1 == -1 && index2 == len) {
            return true;
        }
        return false;
    }
}
