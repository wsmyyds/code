package com.company.specialpractice2;
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 位运算 哈希表 字符串 排序 👍 172 👎 0


public class Code0101 {

    public static void main(String[] args) {

        //a 97 z 122  A 65 Z 90
        //num to char : (char) 95
        //char to num : new Integer('a')
        String testcase1 = "leetcode";
        String testcase2 = "abc";
        System.out.println(isUnique(testcase1));

    }

    //100 82 bitmap
    public static boolean isUnique(String astr) {

        if (astr.length() <= 0) {
            return true;
        }
        int[] arr = new int[52];
        for (int i = 0; i < astr.length(); i++) {
            int cur = astr.charAt(i) - 'A';
            if (cur >= 32) {
                if (arr[cur - 6] == 1) {
                    return false;
                } else {
                    arr[cur - 6] = 1;
                }
            } else {
                if (arr[cur] == 1) {
                    return false;
                } else {
                    arr[cur] = 1;
                }

            }
        }
        return true;
    }

}
