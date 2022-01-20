package com.company;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 1728 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code46 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res= new ArrayList<>();
        if (nums.length==1){
            List<Integer> list = new  ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(res,new ArrayList<>(),nums,visited);
        return res;

    }

    public static void dfs(List<List<Integer>> res, List<Integer> element,  int[] nums,boolean[] visited){

        if (element.size()==nums.length){
            res.add(element);
            return;
        }
        for (int i=0;i<nums.length;i++){

            if (visited[i]){
                continue;
            }

            List<Integer> elm = new ArrayList(element);
            elm.add(nums[i]);
            visited[i] = true;
            dfs(res,elm,nums,visited);
            visited[i] = false;

        }

    }

}
