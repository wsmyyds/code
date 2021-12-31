package com.company.P1;

/**
 * @program: 替换空格
 * @description:
 * @author:
 * @create:
 **/
public class Code05 {

    //https://juejin.cn/post/6844903845227659271正则表达式
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));

    }

    //5 5
    public static String replaceSpace(String s) {


        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res=res.append("%20");
            }else{
                res = res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    //100 18
    public static String replaceSpaceOther(String s) {

        char[] arr = new char[s.length()*3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            }else{
                arr[size++] = s.charAt(i);
            }
        }
        return new String(arr,0,size);
    }

    //100 66
    public static String replaceSpaceOld(String s) {

        return s.replace(" ", "%20");
    }

    //5 5
    public static String replaceSpaceLow(String s) {

        //int[] arr = new int[s.length() * 3];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res=res+"%20";
            }else{
                res = res+s.charAt(i);
            }
        }
        return res;
    }
}
