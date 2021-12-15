package com.company;


/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code748 {

    //toLowerCase()字符串大写转小写
    public static void main(String[] args) {

        String licensePlate = "Ah71752";
        String[] words = new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        System.out.println(shortestCompletingWord(licensePlate,words));

    }

    //取出licensePlate包含的字母并转为小写
    public static String shortestCompletingWord(String licensePlate, String[] words) {

        if (licensePlate.trim().isEmpty()){
            return null;
        }

        int index = -1;
        int[] cnt = getCnt(licensePlate);
        for (int i = 0; i < words.length; i++) {
            int[] cur = getCnt(words[i]);
            boolean ok = true;
            for (int j = 0; j < cur.length; j++) {
                //
                if (cnt[j]>0&&cur[j] < cnt[j]) {
                    ok = false;
                }
            }
            if (ok == true&&(index == -1||words[index].length()>words[i].length())){
                index = i;
            }
        }
        return words[index];
    }

    public static int[] getCnt(String str) {

        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                cnt[Character.toLowerCase(str.charAt(i)) - 'a']++;
            }
        }
        return cnt;
    }

}
