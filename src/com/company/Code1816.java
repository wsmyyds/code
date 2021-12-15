package com.company;

/**
 * @program: [1816]截断句子
 * @description:
 * @author:
 * @create:
 **/
public class Code1816 {

    public static void main(String[] args) {

        String str1 = "What is the solution to this problem";
        System.out.println(truncateSentenceUpdate(str1,4));


    }

    public static String truncateSentence(String s, int k) {

        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <k;i++){
            res.append(str[i]);
            res.append(" ");

        }
        return res.toString().trim();

    }

    public static String truncateSentenceUpdate(String s, int k) {

        int s_len = s.length();
        for (int i = 0; i < s_len;i++){

            System.out.println(k);
            if (s.charAt(i)==' '&&--k==0){
                return s.substring(0,i);
            }


        }

        return s;
    }
}
