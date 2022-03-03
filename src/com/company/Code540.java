package com.company;
//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//
// 请你找出并返回只出现一次的那个数。
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
//
//
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁵
//
// Related Topics 数组 二分查找 👍 359 👎 0


/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code540 {

    public static void main(String[] args) {

        int[] nums = new int[]{5,6,6,7,7,9,9};
        System.out.println(singleNonDuplicate(nums));

    }

    //当正常顺序时，偶数位（eg：第2位的数字1）等于自身减1的奇数位（第1位第一位的数字1）
    //出现目标数字后，偶数位（eg：第6位的数字8）等于自身加1的奇数位（第7位的数字8）
    //如何找到目标数字呢，每次分两半，如果正常顺序则取另一边继续分，不是正常顺序取当前段继续分，以实现O(log n)时间复杂度要求
    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int startIndex = 0, endIndex = nums.length-1;
        while (startIndex<endIndex){

            int mid = (endIndex-startIndex)/2+startIndex;
            if (mid%2==0){
                //偶数位
                if (mid<nums.length-1&&nums[mid]==nums[mid+1]){
                    //正常,取另一边
                    startIndex = mid+2;
                }else{
                    //不正常，取当前
                    endIndex = mid;
                }
            }else{
                //奇数位
                if (mid<nums.length-1&&nums[mid]==nums[mid-1]){
                    //正常,取另一边
                    startIndex = mid+1;
                }else{
                    //不正常，取当前
                    endIndex = mid;
                }
            }

        }
        return nums[startIndex];
    }


    public static int singleNonDuplicate1(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int index1 = 0;
        while (index1 < nums.length) {

            if (nums[index1] != nums[index1 + 1]) {
                return nums[index1];
            }
            index1 += 2;

        }
        return nums[nums.length - 1];
    }
}
