package com.company.P1;

/**
 * @program: code
 * @description: 数组中重复的数字.java
 * @author:
 * @create:
 **/
public class Code03 {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }

    //100 61
    public static int findRepeatNumber(int[] nums) {

        int temp = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i]==nums[nums[i]]){return nums[i];}
            temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    //79 80
    public static int findRepeatNumber1(int[] nums) {

        int numsLen = nums.length;
        byte[] byteArr = new byte[numsLen];
        for (int i = 0; i < numsLen; i++) {

            if (byteArr[nums[i]] == 1) {
                return nums[i];
            }
            byteArr[nums[i]] = 1;

        }
        return -1;
    }

    //或者直接记录遍历过的数，每次都进行遍历
}
