package com.company.specialpractice2;
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。）
//
//
//
// 示例 1：
//
//
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
//
//
// 示例 2：
//
//
//输入："               ", 5
//输出："%20%20%20%20%20"
//
//
//
//
// 提示：
//
//
// 字符串长度在 [0, 500000] 范围内。
//
// Related Topics 字符串 👍 57 👎 0

public class Code0103 {

    /***String[] stringArr = S.split(" ");"Mr John Smith    "to[Mr][John][Smith]*/
    public static void main(String[] args) {

        String testcase1 = "Mr John Smith    ";
        String testcase2 = "               ";
        int len1 = 13;
        int len2 = 5;
        System.out.println(replaceSpaces(testcase2, len2));


    }

    public static String replaceSpaces(String S, int length) {

        if (length == 0) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {

            char curChar = S.charAt(i);
            if (curChar == ' ') {

                res.append("%20");
            } else {
                res.append(curChar);
            }

        }

        return res.toString();
    }

    public static String replaceSpaces1(String S, int length) {

        return S.substring(0, length).replaceAll(" ", "%20");
    }

    public static String replaceSpaces2(String S, int length) {

        //先把字符串转化为字符数组
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }
}
