package com.company.hot100;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2123 👎 0
/**
 * @program: code
 * @description: 爬楼梯.java
 * @author:
 * @create:
 **/

public class Code70 {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }

    /**
     * 1 2 3 5 8...
     * f(n) = f(n-1)+f(n-2)
     * */
    public static int climbStairs(int n) {

        if (n<=2){
            if (n==1) {
                return 1;
            }else{
                return 2;
            }
        }
        int res = 0;
        int pre1 = 2,pre2 = 1;
        int i = 2;
        while(i<n){

            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
            i++;
        }
        return res;
    }
}
