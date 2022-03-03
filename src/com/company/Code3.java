package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code3 {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }


    //75 9 滑动窗口
    //无重复
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int resMax = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                resMax = (i - start + 1) > resMax ? (i - start + 1) : resMax;
            } else if (map.get(s.charAt(i)) >= start) {
                //重复字符在当时字符串中
                resMax = (i - start) > resMax ? (i - start) : resMax;
                start = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            } else{
                map.put(s.charAt(i), i);
                resMax = (i - start + 1) > resMax ? (i - start + 1) : resMax;
            }
        }
        return resMax;
}

    //10 5
    //减少部分重复
    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int resMax = 0;
        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                resMax = resMax > map.size() ? resMax : map.size();
                i = map.get(s.charAt(i));
                map.clear();
            }
        }
        return resMax > map.size() ? resMax : map.size();
    }

    //14 5
    //重复寻找
    public static int lengthOfLongestSubstring1(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int resMax = 0, temp = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {

            if (set.add(s.charAt(i))) {
                resMax++;
            } else {
                if (resMax > temp) {
                    temp = resMax;
                }
                resMax = 0;
                set.clear();
                start++;
                i = start - 1;
            }
        }
        return temp > resMax ? temp : resMax;

    }
}
