package com.company;

import java.util.HashMap;

/**
 * @program: code
 * @description:[1]两数之和
 * @author:
 * @create:
 **/
public class Code1 {

    public static void main(String[] args) {


        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        int[] end = twoSumUp(arr,target);
        System.out.println(end[0]+" "+end[1]);
    }

    //87 98
    public static int[] twoSumUp(int[] nums, int target) {

        int len = nums.length;
        HashMap<Integer, Integer> hashmap = new HashMap(len);
        for (int i = 0; i < len; i++){

            int find = target-nums[i];
            if (hashmap.containsKey(find)){
                return new int[]{hashmap.get(find),i};
            }else{
                hashmap.put(nums[i],i);
            }
        }
        return null;
    }


    public static int[] twoSum(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target||nums[i]<=0) {
                int find = target - nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] == find) {
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }
}
