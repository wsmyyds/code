package com.company.OF;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class CodeOf58 {

    public static void main(String[] args) {

        String str1 = "the sky is blue";
        String str2 = "a good   example";
        //len
        str2 = str2.trim();
        System.out.println(str2.length());
        String[] str_s = str2.split(" ");
        for (int i = 0; i < str_s.length;i ++){
            if (str_s[i] != " "){
                System.out.println(str_s[i]);
            }
        }

        System.out.println(reverseWords(str2));
    }


    public static String reverseWords(String s) {
        //String,StringBuilder,StringBuffer
        //.trim()减去两边空格
        //.split()分开字符串
        if(s.length()<=0){
            return s;
        }

        //String[] str_s = s.split("\\s+");正则表达式去除所有空格，但耗时大大增加
        //s = s.trim();写在一行

        String[] str_s = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        int j = str_s.length - 1;
        while(j>=0){

            //误用==和.equals
            //System.out.println("".equals(str_s[j]));
            if (!str_s[j].equals("")){
                res.append(str_s[j]);
                res.append(" ");
            }
            j--;

        }
        return res.toString().trim();

    }

}
