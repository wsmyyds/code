package com.company.specialpractice2;

//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1:
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
//
// 示例2:
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
//
//
//
// 提示：
//
//
// 字符串长度在[0, 100000]范围内。
//
//
// 说明:
//
//
// 你能只调用一次检查子串的方法吗？
//
// Related Topics 字符串 字符串匹配 👍 94 👎 0


public class Code0109 {

    public static void main(String[] args) {

        String testcase1 = "waterbottle",testcase2 = "erbottlewat";
        String testcase3 = "aa",testcase4 = "aba";
        System.out.println(isFlipedString(testcase1,testcase2));

    }

    public static boolean isFlipedString(String s1, String s2) {

        if (s1.length()!=s2.length()){
            return false;
        }
        if (s1.length()==0){
            return true;
        }

        int[] charNum = new int[52];
        for (int i = 0; i < s1.length();i++){
            int curNumS1 = s1.charAt(i)-'A';
            if (curNumS1<26){
                charNum[curNumS1]++;
            }else{
                charNum[curNumS1-6]++;
            }
            int curNumS2 = s2.charAt(i)-'A';
            if (curNumS2<26){
                charNum[curNumS2]--;
            }else{
                charNum[curNumS2-6]--;
            }
        }
        for (int i = 0; i < charNum.length;i++){
            if (charNum[i]!=0){
                return false;
            }
        }
        return true;
    }

    //旋转一次必定包含
    public static boolean isFlipedString1(String s1, String s2) {

        return (s1.length()==s2.length())&&(s2+s2).contains(s1);
    }

}
