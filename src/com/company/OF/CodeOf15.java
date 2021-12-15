package com.company.OF;

/**
 * @program: code
 * @description: 二进制中1的个数.java
 * @author:
 * @create:
 **/
public class CodeOf15 {

    public static void main(String[] args) {

        //二进制表示
        int n =0b1001;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {

        int res = 0;
        //n!=0 n一直向右移动，最后会变为0
        while(n!=0){
            //盘断最右一位是否是1，是1就加1
            res+=n&1;
            //n无符号有移一位
            n=n>>>1;

        }
        return res;
    }

}
