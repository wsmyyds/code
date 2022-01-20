package com.company;

//给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
//
// 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,6,1,0]
//输出：1
//解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：-1
//解释：4 没有超过 3 的两倍大，所以返回 -1 。
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：0
//解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50
// 0 <= nums[i] <= 100
// nums 中的最大元素是唯一的
//
// Related Topics 数组 排序 👍 142 👎 0

/**
 * @author 13450
 */
public class Code747 {

    public static void main(String[] args) {

        int[] nums1 = new int[]{3, 6, 1, 0};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1, 0};
        System.out.println(dominantIndex(nums3));


    }

    //100 80
    public static int dominantIndex(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int maxValIdx = 0;
        int preMaxValIdx = -1;
        for (int i = 1; i < nums.length; i++) {

//            //当前数比max大，第二大的置为max，max置为当前数
//            if (nums[i] > nums[maxValIdx]) {
//                preMaxValIdx = maxValIdx;
//                maxValIdx = i;
//            }
//            //当前数小于max但大于第二大
//            if (nums[i] > nums[preMaxValIdx] && i != maxValIdx) {
//                preMaxValIdx = i;
//            }
//            //if第一个数是最大的
//            if(preMaxValIdx==maxValIdx){
//                preMaxValIdx=i;
//            }
            if (nums[i] > nums[maxValIdx]) {
                preMaxValIdx = maxValIdx;
                maxValIdx = i;
            }else if(preMaxValIdx==-1||preMaxValIdx<i){
                preMaxValIdx = i;

            }
        }

        //num.len或者preMaxValIdx=0时也满足
        return nums[maxValIdx] >= 2 * nums[preMaxValIdx] ? maxValIdx : -1;
    }
}
