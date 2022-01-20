package com.company;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 913 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code47 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> element = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,visited,element,nums);
        return res;

    }

    public static void dfs(List<List<Integer>> res,boolean[] visited,List<Integer> element,int[] nums){

        if (element.size()==nums.length){
            //5,23
//            if (!res.contains(element)){
                res.add(element);
//            }
            return;
        }
        for (int i = 0; i <nums.length;i++){
            if (visited[i]){
                continue;
            }
            //注意，visited[i-1]
            if (i>0&&nums[i]==nums[i-1]&&!visited[i-1]){
                continue;
            }
            visited[i] = true;
            List<Integer> elm = new ArrayList(element);
            elm.add(nums[i]);
            dfs(res,visited,elm,nums);
            visited[i] = false;
        }
    }
}
