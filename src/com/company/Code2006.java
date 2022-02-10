package com.company;

//给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
//
//
// |x| 的值定义为：
//
//
// 如果 x >= 0 ，那么值为 x 。
// 如果 x < 0 ，那么值为 -x 。
//
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,2,1], k = 1
//输出：4
//解释：差的绝对值为 1 的数对为：
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//
//
// 示例 2：
//
// 输入：nums = [1,3], k = 3
//输出：0
//解释：没有任何数对差的绝对值为 3 。
//
//
// 示例 3：
//
// 输入：nums = [3,2,1,5,4], k = 2
//输出：3
//解释：差的绝对值为 2 的数对为：
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
// 1 <= k <= 99
//
// Related Topics 数组 哈希表 计数 👍 24 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code2006 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 2, 1};
        int k = 1;
        System.out.println(countKDifference(nums, k));


    }

    //为正数k num[i] = num[j] + k| 负数 num[i] - num[j] = -k -> num[i] = num[j] - k
    //这两种都满足|nums[i] - nums[j]| == k
    //84 8
    public static int countKDifference(int[] nums, int k) {

        int res = 0;
        //1 <= nums[i] <= 100 num[i]的值和个数
        int[] arr = new int[101];
        for (int j = 0; j < nums.length; j++) {

            //nums[i] >= 1
            if ((nums[j] - k) >= 1) {
                res += arr[nums[j] - k];
            }
            //nums[i] <= 100
            if ((nums[j] + k) <= 100) {
                res += arr[nums[j] + k];
            }
            arr[nums[j]]++;
            //遍历数组，加上=num[j] + k||num[j] - k的数，将该数也添加进hash表
        }

        return res;
    }

    //    1 <= nums.length <= 200
//    1 <= nums[i] <= 100
//    1 <= k <= 99
    //14 5
    public static int countKDifference1(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
