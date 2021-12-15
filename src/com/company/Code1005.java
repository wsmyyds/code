package com.company;

import java.util.Arrays;


/**
 * @program: code
 * @description:
 *  Related Topics 贪心 数组 排序
 * @author:
 * @create:
 **/
public class Code1005 {

    public static void main(String[] args) {

        int[] nums1 = new int[3];
        nums1[0] = 4;
        nums1[1] = 2;
        nums1[2] = 3;
        int[] nums2 = new int[4];
        nums2[0] = -6;
        nums2[1] = -8;
        nums2[2] = -7;
        nums2[3] = 1;


        System.out.println(largestSumAfterKNegations(nums2,4));

    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
//存在多个负数，优先交换最小负数
        // 负数交换到正数后存在负数
        //                不存在负数，最小数交换k次

//不存在负数，最小数交换k次
        Arrays.sort(nums);
        int min=0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            if (nums[i]<0&&k!=0){
                nums[i] = -nums[i];
                k--;
            }
            if (nums[i]<nums[min]){
                min = i;
            }

        }
        int sum = 0;
        if ((k&1) != 0){
            nums[min] = -nums[min];
            for (int n : nums) {
                sum += n;
            }
        }else{
            for (int n : nums) {
                sum += n;
            }
        }
        //or  return (k&1)==0? sum: sum-nums[min]*2;
        return sum;
    }
}
