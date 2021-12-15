package com.company;

/**
 * @program: code
 * @description: [807]保持城市天际线
 * @author:
 * @create:
 **/
public class Code807 {

    public static void main(String[] args) {

        //int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        //[[57,86,30,56],[59,60,83,95],[83,37,38,98],[15,39,56,86]]
        int[][] grid = new int[][]{
                {57, 86, 30, 56},
                {59, 60, 83, 95},
                {83, 37, 38, 98},
                {15, 39, 56, 86}};

        System.out.println(maxIncreaseKeepingSkylineUp(grid));
        print(grid);

    }

    //从当前点的行和列找到 不大于行和列最大数的那个数
    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] maxr = new int[grid.length];
        int[] maxl = new int[grid[0].length];


        int res = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                //System.out.print(grid[i][j]);
                int c = 0;
                int r = 0;
                int temp1 = 0;
                int temp2 = 0;
                while (c < grid[0].length) {
                    if (grid[i][c] > temp1) {
                        temp1 = grid[i][c];
                    }
                    c++;
                }
                while (r < grid.length) {
                    if (grid[r][j] > temp2) {
                        temp2 = grid[r][j];
                    }
                    r++;
                }
                if (i == 3 && j == 1) {
                    System.out.println("grid[i][j]:" + grid[i][j] + "temp1:" + temp1);

                }
                if (temp1 > temp2 && grid[i][j] != temp2) {
                    res += (temp2 - grid[i][j]);
                    grid[i][j] = temp2;

                } else if (temp1 <= temp2 && grid[i][j] != temp1) {
                    res += (temp1 - grid[i][j]);
                    grid[i][j] = temp1;

                }
            }
            //System.out.println();
        }
        return res;
    }

    public static int maxIncreaseKeepingSkylineUp(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        //l
        int[] maxr = new int[row];
        //r
        int[] maxl = new int[col];
        for (int i = 0; i < row; i++) {//l
            for (int j = 0; j < col; j++) {//r
                maxl[i] = Math.max(grid[i][j], maxl[i]);
                maxr[j] = Math.max(grid[i][j], maxr[j]);
            }
        }

        int res = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                //System.out.print(grid[i][j]);
                if (grid[i][j] < maxr[j] && grid[i][j] < maxl[i]) {
                    res += (Math.min( maxr[j],maxl[i]) - grid[i][j]);
                    grid[i][j] = maxl[i];
                }
            }
            //System.out.println();
        }
        return res;
    }

    public static void print(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
