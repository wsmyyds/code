package com.company;
//给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
//
// 斐波那契数字定义为：
//
//
// F1 = 1
// F2 = 1
// Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
//
//
// 数据保证对于给定的 k ，一定能找到可行解。
//
//
//
// 示例 1：
//
// 输入：k = 7
//输出：2
//解释：斐波那契数字为：1，1，2，3，5，8，13，……
//对于 k = 7 ，我们可以得到 2 + 5 = 7 。
//
// 示例 2：
//
// 输入：k = 10
//输出：2
//解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
//
//
// 示例 3：
//
// 输入：k = 19
//输出：3
//解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
//
//
//
//
// 提示：
//
//
// 1 <= k <= 10^9
//
// Related Topics 贪心 👍 74 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code1414 {

    /***数据保证对于给定的 k ，一定能找到可行解*/
    public static void main(String[] args) {

        System.out.println(findMinFibonacciNumbers(7));
    }

    /**
     * 83 5
     *
     * */
    public static int findMinFibonacciNumbers1(int k) {

        int num1 = 1, num2 = 1, temp = 0, i = 1;
        while (true) {
            //find first num low k
            while (num2 <= k) {

                if (num2 == k) {
                    return i;
                }
                temp = num2;
                num2 = num2 + num1;
                num1 = temp;
            }
            //nums2>k so num1 is first low k
            i++;
            k = k - num1;
            num1 = 1;
            num2 = 1;
        }
    }

    //100 5
    public static int findMinFibonacciNumbers(int k) {

        if (k==0) {
            return 0;
        }

        int a = 1,b = 1;
        while(a+b<=k){
            int c = a+b;
            a = b;
            b = c;
        }
        return findMinFibonacciNumbers(k-b)+1;
    }
}
