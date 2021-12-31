package com.company;

/**
 * @program: code
 * @description: 完美数.java
 * @author:
 * @create: 正因子（又正约数）：大于0的整数因数，任何整数的最小正因子都是1
 * 因数：整数a除以b（b!=0）的商正好是整数没有余数,就说b是a的因数
 * --如6的正因子1 2 3 6,正因子包含本身，完美数是除它自身以外的所有正因子
 **/
public class Code507 {

    public static void main(String[] args) {

        int num = 28;
        System.out.println(checkPerfectNumber(num));
    }

    //根据欧拉定理，在10⁸内完美数只有这几个
    public static boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    //96 5
    public static boolean checkPerfectNumber2(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                //正因数总成对出现，即a是一个正因数，则有另一个正因数num/a，[2,num^1/2]
                if (i * i < num) {
                    sum += (num / i);
                }
            }
        }
        return sum == num ? true : false;

    }

    //21 45
    public static boolean checkPerfectNumber1(int num) {

        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if ((num % i) == 0) {
                sum += i;
            }
        }
        return sum == num ? true : false;
    }
}
