package com.company.specialpractice2;
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 哈希表 字符串 排序 👍 53 👎 0

import java.util.Arrays;

public class Code0102 {

    public static void main(String[] args) {

        String testcase1 = "abc", testcase2 = "bca";
        String testcase3 = "abc", testcase4 = "bad";
        System.out.println(CheckPermutation(testcase1,testcase2));

    }

    //100 63
    public static boolean CheckPermutation(String s1, String s2) {

        if (s1.length() <= 0 || s2.length() <= 0) {
            if (s1.length() <= 0 && s2.length() <= 0) {
                return true;
            }
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {

            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {

            arr[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i <arr.length; i++){
            if (arr[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static boolean CheckPermutationeasy(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return new String(arr1).equals(new String(arr2));
    }

}
