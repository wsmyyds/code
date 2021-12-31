package com.company.OF;

import java.util.HashMap;

/**
 * @program: code
 * @description: 和为s的两个数字.java
 * @author:
 * @create:
 **/
public class Code57 {

    public static void main(String[] args) {

        //[16,16,18,24,30,32]
        //48
        int[] arr = new int[]{16, 16, 18, 24, 30, 32};
        int target = 48;
        int[] res = twoSum(arr, target);
        System.out.println(res[0] + "   " + res[1]);
    }

    //有序数组使用双指针
    //78 19
    public static int[] twoSum(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i < j) {

            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }else{
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{};
    }

    //16 7
    public static int[] twoSum1(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{nums[i], map.get(nums[i])};
            }
        }
        return new int[]{};
    }

}
