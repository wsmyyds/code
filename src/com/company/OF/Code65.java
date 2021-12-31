package com.company.OF;

/**
 * @program: code
 * @description: 不用加减乘除做加法.java
 * @author:
 * @create:
 **/
public class Code65 {

    public static void main(String[] args) {

        int a = 111, b = 899;
        System.out.println(add(a,b));

        //3 11 4 100
//        System.out.println(3 & 4); //000 0
//        System.out.println(3 ^ 4);//111 7
//        System.out.println(~4);//
//        System.out.println(4 << 1);//1000 8
//        System.out.println(4 >> 1);//10 2
//        System.out.println(4 >>> 1);
    }


    public static int add(int a, int b) {

        //不一定只循环两次
        while (b != 0) {
            //1005  2400
            //1000
            //当最后一位都为1时才为1，<<1位代替进位，所有需要进位的数都进位完成，忽略本位操作
            int res = (a&b)<<1;
            System.out.println(res);
            //11
            //当两个数的同位不相同时才保留，代替本位加操作，所有本位加都正确完成，忽略进位
            a = a^b;
            System.out.println(a);
            //b变为进位后的结果
            b = res;
            System.out.println(b);
            System.out.println(" ");

        }
        return a;
    }

}
