package com.company.P1;

/**
 * @program: code
 * @description:左旋转字符串.java
 * @author:
 * @create:
 **/
public class Code58 {

    public static void main(String[] args) {

//        String s = "abcdefg";
//        int k = 2;
        String s = "lrloseumgh";
        int k = 6;
        System.out.println(reverseLeftWords(s,k));
    }

    //100 17
    public static String reverseLeftWords(String s, int n) {

        return s.substring(n)+s.substring(0,n);
    }

    //100 60
    public static String reverseLeftWordsOther(String s, int n) {

        char arr[] = s.toCharArray();
        //return new StringBuilder().append(arr,n,arr.length-n).append(arr,0,n).toString();//60 50
        return new String(arr,n,arr.length-n)+new String(arr,0,n);
    }

    //35 34
    public static String reverseLeftWordsOld(String s, int n) {

        StringBuilder str = new StringBuilder();
        for (int i = n; i < s.length(); i++){
            str.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }

}
