package com.company;

//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
//
//
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
//
// 示例 2：
//
//
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
//
// 示例 3：
//
//
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
//
//
// 示例 4：
//
//
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= s.length, goal.length <= 2 * 10⁴
// s 和 goal 由小写英文字母组成
//
// Related Topics 哈希表 字符串 👍 253 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code859 {

    public static void main(String[] args) {
        String s = "aa", goal = "aa";

//        System.out.println((int)'a');
//        System.out.println((int)'z');
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        //不要使用==
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
                if (count[s.charAt(i)-'a']>1) {
                    return true;
                }
            }
            return false;
        }

        int dif = -1,difIndex = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {
                if (dif==-1){
                    dif = i;
                }
                else {
                    if (dif==-2||dif==-3){
                        dif = -3;
                        continue;
                    }
                    if(s.charAt(i) == goal.charAt(dif)&& s.charAt(dif) == goal.charAt(i)){
                        dif = -2;
                    }else{
                        dif = -3;
                    }
                }
            }
        }
        if (dif == -2) {
            return true;
        }
        return false;
    }
}
