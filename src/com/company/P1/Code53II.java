package com.company.P1;

/**
 * @program: code
 * @description:0～n-1中缺失的数字.java
 * @author:
 * @create:
 **/
public class Code53II {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8,10};
        System.out.println(9 & 10);
        System.out.println(missingNumber(arr));
    }


    //二分
    public static int missingNumber2(int[] nums) {

        int i = 0, j = nums.length-1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (m == nums[m]) {
                i = m + 1;
            } else {
                j = m-1;
            }
        }
        return i;

    }


    //100 91 位运算?
    public static int missingNumber(int[] nums) {

        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (( i&nums[i]) != nums[i]) {
                return i;
            }
        }
        //输入[0] 要返回1 ; [0,1] 返回 2
        return i;
    }

}
