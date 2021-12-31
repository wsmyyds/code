package com.company.OF;

/**
 * @program: code
 * @description: 圆圈中最后剩下的数字.java
 * @author:
 * @create:
 **/
public class Code62 {

    public static void main(String[] args) {

        int n = 5, m = 3;
        System.out.println(lastRemaining(n,m));
    }

    //todo 圆圈中最后剩下的数字
    public static int lastRemaining(int n, int m) {

        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res+m)%i;
        }
        return res;
    }

}
