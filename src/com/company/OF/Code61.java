package com.company.OF;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: code
 * @description: 扑克牌中的顺子.java
 * @author:
 * @create:
 **/
public class Code61 {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 0, 2, 2, 5};
        System.out.println(isStraight1other(arr));

    }

    //推出条件最大值-最小值<5,无论有无0都是一样
    //100 5
    public static boolean isStraight(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>(5);
        int max = 1, min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            if (!hashSet.add(nums[i])) {
                return false;
            }
        }

        return max - min < 5;
    }

    //1的更新版
    public static boolean isStraight1other(int[] nums) {

        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                j++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;

            }
        }
        return nums[4] - nums[j] < 5;
    }

    //100 12
    public static boolean isStraight1(int[] nums) {

        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                j++;
                continue;
            }
            if (nums[i] + 1 != nums[i + 1]) {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
                j = j - (nums[i + 1] - nums[i]);
                if (j >= -1) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
