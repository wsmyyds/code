package com.company;

//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：[3]
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：[1]
//
//
// 示例 3：
//
//
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
// Related Topics 数组 哈希表 计数 排序 👍 553 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code229 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
        int[] arr1 = new int[]{2,1,1,3,1,4,5,6};
        System.out.println(majorityElement(arr1));
    }

    //超过n/3，res总数必然<3 ; 99 43
    public static List<Integer> majorityElement(int[] nums) {

        int res1 = 0,res2 = 0;
        int count1 = 0,count2 = 0;
        for (int i:
             nums) {
            if (count1==0&&res2!=i){
                res1=i;
                count1++;
                continue;
            }
            if (count2==0&&res1!=i){
                res2=i;
                count2++;
                continue;
            }
            if (res1==i){
                count1++;
            }else if (res2==i){
                count2++;
            } else{
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 =0;
        for (int i:
             nums) {
            if (i == res1){
                count1++;
            }
            if (i == res2){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1>nums.length/3){
            res.add(res1);
        }
        //避免[0,0,0]结果为[0,0]
        if (count2>nums.length/3&&res2!=res1){
            res.add(res2);
        }
        return res;
    }

    //36,85 t:O(n) s:O(n)
    public static List<Integer> majorityElement1(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int curNum : nums
        ) {
            if (hashMap.containsKey(curNum)) {
                hashMap.put(curNum, hashMap.get(curNum) + 1);

            } else {
                hashMap.put(curNum, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i :
                hashMap.keySet()) {
            if (hashMap.get(i) > (nums.length / 3)) {
                res.add(i);
            }
        }
        return res;
    }

}
