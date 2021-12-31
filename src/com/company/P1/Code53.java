package com.company.P1;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code53 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int i = 8;
        search(arr, i);
    }

    //100 76
    public static int search2(int[] nums, int target) {

        return find(nums, target) - find(nums, target - 1);

    }


    public static int find(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }


    //26 8
    public static int search(int[] nums, int target) {

        int res = 0;
        if (nums.length <= 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                res++;
            }

        }
        return res;
    }
}
