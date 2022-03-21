package com.company;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad" dabab
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics 字符串 动态规划 👍 4839 👎 0

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code5 {

    public static void main(String[] args) {

        String s = "babbad";

//        System.out.println(new String("1768fd44ce359bd233cadf3bc5c855cf").length());
        //System.out.println(longestPalindrome(s));
        String json = readJsonFile("my.json");
        JSONObject json_obj = JSONObject.parseObject(json);
        JSONArray res = json_obj.getJSONArray("msg");
        Set resList = new HashSet();
        List list = new ArrayList();
        for (int i = 0; i < res.size(); i++) {
            JSONObject curCol =  res.getJSONObject(i);
            String strCur = curCol.getString("time").substring(0,10);
            resList.add(strCur);
            list.add(strCur);
        }
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.size()/2);
        System.out.println(resList);
        System.out.println(resList.size());

    }

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String longestPalindrome(String s) {

        if (s.length()<=1){
            return s;
        }
        int start = 0,end = s.length()-1;
        StringBuilder sb = new StringBuilder("");
        String res = null;
        while(start<=end){
            if (s.charAt(start)==s.charAt(end)){
                sb.append(s.charAt(start));
            }else if(sb.length()>0){
                if (sb.length()>res.length()){
                    res = sb.toString();
                }
                sb.delete(0,sb.length()-1);
            }
            start++;
            end--;
        }
        if (sb.length()>0){
            return sb.toString();
        }
        return res;
    }
}
