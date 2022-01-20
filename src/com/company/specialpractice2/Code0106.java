package com.company.specialpractice2;

//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//
// 示例1:
//
//
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
//
//
// 示例2:
//
//
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//
//
// 提示：
//
//
// 字符串长度在[0, 50000]范围内。
//
// Related Topics 双指针 字符串 👍 115 👎 0

public class Code0106 {

    public static void main(String[] args) {

        String testcase1 = "aabcccccaaa";
        String testcase2 = "abbccd";

        System.out.println(compressString(testcase2));
    }

    public static String compressString(String S) {

        if (S.length() <= 0) {
            return "";
        }
        int i = 0;
        char preChar;
        StringBuilder res = new StringBuilder();
        while (i < S.length()) {
            preChar = S.charAt(i);
            res.append(preChar);
            i++;
            int count = 1;
            //outOfIndex
            while(i<S.length()&&S.charAt(i) == preChar){
                count++;
                i++;
            }
            res.append(count);

        }

        return res.length()<S.length()?res.toString():S;

    }
}
