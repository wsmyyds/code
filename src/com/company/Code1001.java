package com.company;

//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
//
// 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli]
//的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。
//
// 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。
//
// 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj]
// 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个
//方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
//
// 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。
//
//
//
// 示例 1：
//
//
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//输出：[1,0]
//解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）
//。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
//
//第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
//
//
//
// 示例 2：
//
//
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//输出：[1,1]
//
//
// 示例 3：
//
//
//输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//输出：[1,1,0]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
// 0 <= lamps.length <= 20000
// 0 <= queries.length <= 20000
// lamps[i].length == 2
// 0 <= rowi, coli < n
// queries[j].length == 2
// 0 <= rowj, colj < n
//
// Related Topics 数组 哈希表 👍 59 👎 0

import java.util.HashMap;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code1001 {

    public static void main(String[] args) {

        int n = 5;
        int[][] lamps = new int[][]{{0, 0}, {1, 0}};
        int[][] queries = new int[][]{{1, 1}, {1, 1}};
//        System.out.println(lamps.length);//hangshu
//        System.out.println(lamps[0].length);//leishu
        System.out.println(gridIllumination(n, lamps, queries));

    }

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        HashMap<Integer,Integer> row = new HashMap<Integer,Integer>(n);
        HashMap<Integer,Integer> col = new HashMap<>(n);
        return new int[0];
    }

    //1 <= n <= 109
    //0 <= lamps.length <= 20000
    //0 <= queries.length <= 20000
    //lamps[i].length == 2
    //0 <= rowi, coli < n
    //queries[j].length == 2
    //0 <= rowj, colj < n

    public static int[] gridIlluminationfail(int n, int[][] lamps, int[][] queries) {

        int[][] grid = new int[n][n];
        int[] res = new int[queries.length];
        boolean[][] checkLights = new boolean[n][n];

        for (int i = 0; i < lamps.length; i++) {
            int row = lamps[i][0], col = lamps[i][1];
//            grid[row][col]+= 1;
            checkLights[row][col] = true;
            int start = 0;
            while (start < n) {
                //hang
                grid[row][start] += 1;
                if (start != 0) {
                    grid[start][col] += 1;
                    if (row + start < n && col + start < n) {
                        grid[row + start][col + start] += 1;
                    }
                    if (row - start > 0 && col - start > 0) {
                        grid[row - start][col - start] += 1;
                    }

                    if (row - start > 0 && col + start < n) {
                        grid[row - start][col + start] += 1;
                    }
                    if (row + start < n && col - start > 0) {
                        grid[row + start][col - start] += 1;
                    }
                }
                start++;
            }
        }

        for (int i = 0; i < lamps.length; i++) {
            int row = queries[i][0], col = queries[i][1];
            if (grid[row][col] > 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
            if (checkLights[row][col]){
                grid[row][col] -= 1;
                if (row - 1 >= 0) {
                    grid[row - 1][col] -= 1;
                    if (col - 1 >= 0) {
                        grid[row - 1][col - 1] -= 1;
                    }
                    if (col + 1 < n) {
                        grid[row - 1][col + 1] -= 1;
                    }
                }
                if (row + 1 < n) {
                    grid[row + 1][col] -= 1;
                    if (col - 1 >= 0) {
                        grid[row + 1][col - 1] -= 1;
                    }
                    if (col + 1 < n) {
                        grid[row + 1][col + 1] -= 1;
                    }
                }
                if (col - 1 >= 0) {
                    grid[row][col - 1] -= 1;
                }
                if (col + 1 < n) {
                    grid[row][col + 1] -= 1;
                }
            }

        }
        return res;

    }

}
