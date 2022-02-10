package com.company;

//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。
//
//
//
// 示例 1：
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
//
// 示例 2：
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
//
//
// 示例 3：
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
//
// 示例 4：
//
// 输入：n = 1
//输出：[]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 100
//
// Related Topics 数学 字符串 数论 👍 46 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code1447 {

    public static void main(String[] args) {

        int n = 5;
        System.out.println(gcd(5,3));
        System.out.println(simplifiedFractions(n));
    }

    public static List<String> simplifiedFractions(int n) {

        if (n == 1) {
            return new ArrayList<>();
        }
        List<String> resList = new ArrayList<>();
        //分母
        for (int i = 2; i <= n; i++) {
            //分子
            resList.add(1+"/"+i);
            for (int j = 2;j<i;j++){
                if (gcdUp(i,j)==1){
                    resList.add(j+"/"+i);
                }
            }
        }
        return resList;
    }

    //Greatest Common Divisor
    //欧几里得算法/辗转相除法
    //输入x>y
    public static int gcd(int x, int y) {
        int temp = y;
        y = x%y;
        if (y == 0){
            return temp;
        }
        x = temp;
        return gcd(x,y);
    }

    public static int gcdUp(int x, int y) {

        return y==0? x:gcdUp(y,x%y);
    }

    //更相减损术
    //输入x>y
    public static int gcd1(int x, int y) {

        if (y==0){
            return x;
        }
        if (x%2==0&&y%2==0){
            return gcd1(x/2,y/2)*2;
        }else{
            if (x>y){
                return gcd1(y,x-y);
            }else{
                return gcd1(x,y-x);
            }
        }
    }

    public static int gcd1Up(int x, int y) {
        while(true){
            if (x>y){
                x=x-y;
            }else if (x<y){
                y=y-x;
            }else{
                return x;
            }
        }
    }

    // stein


}
