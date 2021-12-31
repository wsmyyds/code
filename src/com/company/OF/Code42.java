package com.company.OF;

/**
 * @program: code
 * @description: 连续子数组的最大和.java
 * @author:
 * @create:
 **/
public class Code42 {


    public static void main(String[] args) {

        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));

    }

    //dp
    //dp[i-1]>0就dp[i]+dp[i-1]
    //暴力
    //每个元素判断，判断条件与周围的数加起来大于本身，然后比较每个数和
    public static int maxSubArray(int[] nums) {

//        if (nums.length == 1) { 多余
//            return nums[0];
//        }
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            if (maxValue < nums[i]) {
                maxValue = nums[i];

            }
        }
        return maxValue;
    }

//    public static int maxSubArray(int[] nums) {
//
//        int maxValue = 0;
//        if (nums.length<=4){
//            for (int i = 0; i<nums.length; i++){
//                maxValue+=nums[i];
//            }
//            return maxValue;
//        }
//        maxValue = nums[0]+nums[1]+nums[2]+nums[3];
//        for (int i = 4; i < nums.length; i++) {
//            int temp = nums[i-3]+nums[i-2]+nums[i-1]+nums[i];
//            if (maxValue<temp) {
//                maxValue = temp;
//            }
//        }
//        return maxValue;
//    }
}
