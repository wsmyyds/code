package com.company.specialpractice1;

/**
 * @program: code
 * @description: 斐波那契数.java
 * @author:
 * @create:
 **/
public class Code509 {

    public static void main(String[] args) {

        int num = 4;
        System.out.println(fib(num));
    }

    /**
     * @Description: 状态转移方程：
     * f(n)= 1 n=1,2
     *     = f(n-1)+f(n-2) n>2
     * 本质为暴力解的优化
     */
    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }
//        if (n <= 2) {
//            return 1;
//        }
        int numCur = 1, numPre = 1, temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = numCur;
            numCur = numCur + numPre;
            numPre = temp;
        }
        return numCur;
    }
}
