package com.company.hot100;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1]
//输出：[2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 10⁵
// 1 <= nums[i] <= n
//
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
// Related Topics 数组 哈希表 👍 882 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @program: code
 * @description: [448]找到所有数组中消失的数字
 * @author:
 * @create:
 **/
public class Code448 {

    public static void main(String[] args) {

        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    //空间O(1)原地加减
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        for (int i = 0;i<nums.length;i++){
            int x = (nums[i]-1)%len;
            nums[x] +=  len;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            //数字从1开始
            if (nums[i]<len+1){
                res.add(i%len+1);
            }
        }
        return res;
    }

    //100 45
    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        boolean[] numsOther = new boolean[nums.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            numsOther[nums[i]-1]=true;
        }
        for (int i = 0;i<numsOther.length;i++){
            if (!numsOther[i]){
                res.add(i+1);
            }
        }
        return res;
    }
}
