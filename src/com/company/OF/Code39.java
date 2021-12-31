package com.company.OF;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: code
 * @description: 数组中出现次数超过一半的数字.java
 * @author:
 * @create:
 **/
public class Code39 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        //int[] arr = new int[]{10, 9, 9, 9, 10};
        System.out.println(majorityElement(arr));

    }

    //55 24
    public static int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //6 82
    public static int majorityElement2(int[] nums) {

        int res = nums[0];
        //加上nums.length/2空间占用变高
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(nums[i])){

                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
            if (hashMap.get(nums[i])>hashMap.get(res)){

                res = nums[i];
            }

        }

        return res;

    }


    //摩尔投票法 99 50
    public static int majorityElement1(int[] nums) {

        int res = nums[0], twice = 1;

        for (int i = 1; i < nums.length; i++) {

            if (twice == 0) {
                res = nums[i];
                twice ++;
                continue;
            }

            if (nums[i] == res) {
                twice++;
            } else {
                twice--;
            }

        }
        return res;
    }

    //暴力
    //随机
    //分治算法递归
}
