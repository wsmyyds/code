package com.company.specialpractice1;

import java.util.Arrays;

/**
 * @program: code
 * @description: 零钱兑换.java
 * @author:
 * @create:
 **/
public class Code322 {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }

    /**
     * @Description: 状态转移方程
     * 所需硬币个数 f(amount) = 0 amount=0
     *                       = -1 ∀coins!=amount 所有硬币组合都无法构成amount
     *                       = min(f(amount-coin)+1)
     * 状态转移方程:将状态变为表达式f(amount-coin)+1可以一直转移到需要的任意位置
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int max = amount + 1;
        int[] amounts = new int[max];
        Arrays.fill(amounts, max);
        //注意第一位为0
        amounts[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i){
                    amounts[i] = Math.min(amounts[i],amounts[i-coins[j]]+1);
                }

            }
        }
        //amounts[i]存储该i金额所需最少硬币数，初始值是amount+1
        return amounts[amount]>amount?-1:amounts[amount];
    }


    /**
     * @Description: 暴力递归
     */
    static int res = Integer.MAX_VALUE;

    public static int coinChange1(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        back(coins, amount, 1);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }

    public static void back(int[] coins, int amount, int count) {

        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (amount > 0) {
            for (int i = coins.length - 1; i >= 0; i--) {

                //注意：不能加在这里，会影响递归变量
                //count++;
                //amount=amount-coins[i];
                back(coins, amount - coins[i], count++);
            }
        }
    }
    //qaq避免使用递归，debug麻烦


}

