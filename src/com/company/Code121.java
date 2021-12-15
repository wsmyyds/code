package com.company;

/**
 * @program: code
 * @description: 买卖股票的最佳时机
 * @author:
 * @create:
 **/
public class Code121 {

    public static void main(String[] args) {
        //int[] arr = new int[]{7,1,5,3,6,4};
        //int[] arr = new int[]{7,6,4,3,1};
        int[] arr = new int[]{1, 2};
        System.out.println(maxProfitUp(arr));

    }

    public static int maxProfitUp(int[] prices) {

        int indexMin = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < prices[indexMin]) {
                indexMin = i;
            }
            if (prices[i] - prices[indexMin] > res) {

                res = prices[i] - prices[indexMin];
            }

        }
        return res;

    }

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int index = 0;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] <= prices[index]) {
                index = i;
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] - prices[index] > res) {
                        res = prices[j] - prices[index];
                    }
                }
            }
        }

        return res;
    }
}
