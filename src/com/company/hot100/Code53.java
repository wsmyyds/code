package com.company.hot100;

/**
 * @program: code
 * @description: 最大子数组和.java
 * @author:
 * @create:
 **/
public class Code53 {

    public static void main(String[] args) {

        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));


    }

    /**
     * @Description: max(f(i-1),i)
     */
    public static int maxSubArray(int[] nums) {

        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            //if (nums[i]<nums[i-1]+nums[i]){
            if (0<nums[i-1]){
                nums[i] = nums[i-1]+nums[i];
            }
            if (nums[i]>res){
                res = nums[i];
            }
        }
        return res;
    }
}
