package com.company.OF;

/**
 * @program:
 * @description: 调整数组顺序使奇数位于偶数前面
 * 首尾双指针   [快慢双指针]
 * @author:
 * @create:
 **/
public class CodeOf21 {

    public static void main(String[] args) {
        //def 数组
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        System.out.println(nums.length);

        nums = exchangeUpdate(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }


    public static int[] exchangeUpdate(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }

        int temp;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            // &1 结果等同于 %2
            //可能出现左边连续都为奇数，或者右边两虚都为偶数情况
            while(i < j && (nums[i] & 1) != 0){
                    i++;
            }
            while(i < j && (nums[j] & 1) == 0){
                j--;
            }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }
        return nums;
    }

    public static int[] exchange(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }

        int temp;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 != 0) {
                i++;
            }
            if (nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            if (nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                j--;
            }

        }
        return nums;
    }
}
