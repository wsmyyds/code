package com.company;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串 👍 2072 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code14 {

    public static void main(String[] args) {

        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length ==0){
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0;j < result.length()&&j<strs[i].length();j++){
                if(result.charAt(j)==strs[i].charAt(j)){
                    continue;
                }else{
                    result = result.substring(0,j);
                }
            }
            if (result.length()> strs[i].length()){
                result = strs[i];
            }
        }
        return result;

    }
}
