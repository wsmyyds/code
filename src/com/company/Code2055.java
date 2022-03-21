package com.company;

//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
//' 表示一支 蜡烛 。
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
//lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
//
//
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
//
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
//
//
//
// 示例 1:
//
//
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
//
//
// 示例 2:
//
//
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
//
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
//
//
//
//
// 提示：
//
//
// 3 <= s.length <= 10⁵
// s 只包含字符 '*' 和 '|' 。
// 1 <= queries.length <= 10⁵
// queries[i].length == 2
// 0 <= lefti <= righti < s.length
//
// Related Topics 数组 字符串 二分查找 前缀和 👍 39 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code2055 {

    public static void main(String[] args) {

        //String s = "**|**|***|";
        //String s = "***|**|*****|**||**|*";
        String s = "**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***";

        System.out.println(s.length());
//        System.out.println(s.charAt(0)+" "+s.charAt(16));
        //int[][] queries = new int[][]{{2,5},{5,9}};
        //int[][] queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        int[][] queries = new int[][]{{0,180}};
        System.out.println(platesBetweenCandles(s,queries));

    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {

        int[] arr = new int[s.length()];
        //避免几个蜡烛一起，直接前缀和和蜡烛位置分开存放
        int[] leftArr = new int[s.length()];
        int[] rightArr = new int[s.length()];
        //保存当前位置的前缀和，保存所有蜡烛的位置，省去queries次的遍历s
        int sum = 0,l=0,r=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='*'){
                sum++;
            }else{
                //当为蜡烛时
                l=i;
            }
            leftArr[i]=l;
            arr[i]=sum;
        }
        //注意i可等于0，不然导致取值出错qaq
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)=='|'){
                r=i;
            }
            rightArr[i]=r;
        }
        //结果集数组
        int[] res = new int[queries.length];
        int resIndex = 0;
        for (int[] cur:
                queries) {

            int left = cur[0],right = cur[1];
            //
            if(right>rightArr[left]&&left<leftArr[right]){

                left=rightArr[left];
                right=leftArr[right];
                res[resIndex++]=arr[right]-arr[left];
            }else{
                res[resIndex++]=0;
            }

        }
        return res;
    }

    //ttl,替换掉while，可用二分
    public static int[] platesBetweenCandles2(String s, int[][] queries) {

        int[] arr = new int[s.length()];
        //避免几个蜡烛一起，直接前缀和和蜡烛位置分开存放
        boolean[] larr = new boolean[s.length()];
        //保存当前位置的前缀和，保存所有蜡烛的位置，省去queries次的遍历s
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='*'){
                sum++;
                larr[i] = false;
            }else{
                //当为蜡烛时
                larr[i]=true;
            }
            arr[i]=sum;
        }
        //结果集数组
        int[] res = new int[queries.length];
        int resIndex = 0;
        for (int[] cur:
                queries) {

            int left = cur[0],right = cur[1];
            //找到>=left位置的第一个蜡烛，同时left位置必然是<=right的
            while(left<right){
                //当为-1表示找到了蜡烛，直接退出即可
                if (larr[left]){
                    break;
                }
                left++;
            }
            //找右边最近的蜡烛
            while(right>left){
                if (larr[right]){
                    break;
                }
                right--;
            }
            res[resIndex++]=arr[right]-arr[left];

        }
        return res;

    }

    //TTL
    public static int[] platesBetweenCandles1(String s, int[][] queries) {

        int[] res = new int[queries.length];
        int resIndex = 0;
        for (int[] cur:
             queries) {
            int left = cur[0],right = cur[1];
            while(left<right){

                if (s.charAt(left)!='|'){
                    left++;
                    continue;
                }
                if (s.charAt(right)!='|'){
                    right--;
                    continue;
                }
                left++;
                while(left<right){
                    if (s.charAt(left)=='*'){
                        res[resIndex]++;
                    }
                    left++;
                }
                //注意resIndex++不能放在此处
            }

            resIndex++;
        }
        return res;
    }
}
