package com.company;
//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
//
//
//
// 示例 1：
//
//
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
//
//
// 示例 2：
//
//
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 30
// 所有输入的字符串 words[i] 都只包含小写字母。
//
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 208 👎 0

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code720 {

    public static void main(String[] args) {

        String[] strArr = new String[]{"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
        System.out.println(longestWord(strArr));


    }

    public static String longestWord(String[] words) {

        Map map = new HashMap();
        for (String str:
             words) {
            map.put(str,null);
        }
        Set set = new HashSet();
        String maxStr = "";
        Arrays.sort(words);
        for (String str:
                words) {
            String curStr = str.substring(0,str.length()-1);
            if (map.containsKey(curStr)||curStr.equals("")){
             if (str.length()>maxStr.length()){
                 maxStr = str;
             }else if (str.length()==maxStr.length()&&str.compareTo(maxStr)<0){
                 maxStr = str;
             }
            }else if(str.length()>1){
                map.remove(str);
            }
        }
        return maxStr;
    }
}
