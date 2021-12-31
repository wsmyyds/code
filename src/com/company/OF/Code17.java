package com.company.OF;

/**
 * @program: code
 * @description: 打印从1到最大的n位数.java
 * @author:
 * @create:
 **/
public class Code17 {

    public static void main(String[] args) {

        int[] nums = printNumbers(1);
        System.out.println(nums);
    }

    // TODO: 考虑大数解法

    //96,47
    public static int[] printNumbers(int n) {

        int maxNum = (int)Math.pow(10,n);
//        while (n != 0) {
//            maxNum = 10 * maxNum;
//            n--;
//        }

        //maxNum = maxNum - 1;
        int[] nums = new int[maxNum-1];
        for (int i = 1; i < maxNum; i++) {
            nums[i-1] = i;
        }
        return nums;
    }
}
