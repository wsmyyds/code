package com.company.OF;

import java.util.HashMap;

/**
 * @program: code
 * @description: 第一个只出现一次的字符.java
 * @author:
 * @create:
 **/
public class Code50 {

    public static void main(String[] args) {

        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));

    }

    //62 94
    public static char firstUniqChar(String s) {

        HashMap<Character, Boolean> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsKey(charArr[i])) {
                map.put(charArr[i], false);
            } else {
                map.put(charArr[i], true);
            }
        }
        for (int i = 0; i < charArr.length; i++) {
            if (map.get(charArr[i]) == true) {
                return charArr[i];
            }
        }

        return ' ';
    }


}
