package com.company.hot100;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 1279 👎 0
/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code169 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,2,1,1,1,2,2};
        int[] arr1 = new int[]{6,5,5};
        System.out.println(majorityElement(arr1));

    }

    //hashmap 存对应数字和次数
    //排序取nums[len/2]
    //分

    //61 45
    public static int majorityElement(int[] nums) {

        int[] resNum = new int[2];
        for (int curNum:
             nums) {
            if (resNum[1]==0){
                resNum[0] = curNum;
                resNum[1] = 1;
                continue;
            }
            if (resNum[0]==curNum){
                resNum[1]++;
            }else{
                resNum[1]--;
            }
        }
        return resNum[0];
    }

}
