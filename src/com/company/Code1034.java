package com.company;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code1034 {

    private static boolean[][] checked;

    public static void main(String[] args) {

//        int[][] arr = new int[][]{{1,2,1,2,1,2},
//                                  {2,2,2,2,1,2},
//                                  {1,2,2,2,1,2}};
        int[][] arr = new int[][]{{1,1,1},
                {1,1,1},
                {1,1,1}};
        System.out.println(arr.length);
        int j = 0;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i][j]);
//            if (i == arr.length - 1 && j != arr[0].length - 1) {
//                i = -1;
//                j++;
//                System.out.println();
//            }
//        }

        arr = colorBorder(arr, 1, 1, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][j]);
            if (i == arr.length - 1 && j != arr[0].length - 1) {
                i = -1;
                j++;
                System.out.println();
            }
        }

    }

    //color条件：int[row][col]开始
    //上：int[row-1][col] == int[row][col]
    // 判断int[row-1][col]四个方向是否都有等于自己的color s>不着色，传递上左右 否>着色，传递相同color的位置
    //下：int[row+1][col] == int[row][col]
    //左：int[row][col-1] == int[row][col]
    //右：int[row][col+1] == int[row][col]
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int o = grid[row][col];
        int m = grid.length;
        int n = grid[0].length;
        checked = new boolean[m][n];
        color(grid, row, col, o, m, n, color);
        //grid[row][col] = color;

        return grid;
    }

    //o原本颜色,m最大row,n最大col,color,要染的颜色
    public static void color(int[][] grid, int row, int col, int o, int m, int n, int color) {

        int t = 0;
        if (!checked[row][col]) {//判断该位置是否已经找过，找过就跳过
            if (grid[row][col] == o) {
                checked[row][col] = true;
                //上
                if (row > 0&&grid[row][col] == grid[row-1][col]) {//当节点不在上边界（即还有row-1）并且和上面一个节点相等
                    color(grid, row - 1, col, o, m, n, color);
                } else if ((row == 0) || !checked[row-1][col]){//当该节点位于上边界或者没有检查过
                    t++;
                }
                //下
                if (row < m - 1&&grid[row][col] == grid[row+1][col]) {
                    color(grid, row + 1, col, o, m, n, color);
                } else if ((row == m - 1) || !checked[row+1][col]){
                    t++;
                }
                //左
                if (col > 0&&grid[row][col] == grid[row][col-1]) {
                    color(grid, row, col - 1, o, m, n, color);
                } else if ((col == 0)||!checked[row][col-1]){
                    t++;
                }
                //右
                if (col < n - 1&&grid[row][col] == grid[row][col+1]) {
                    color(grid, row, col + 1, o, m, n, color);
                } else if (col == n-1||!checked[row][col+1]){
                    t++;
                }
            }
            if (t > 0) {
                grid[row][col] = color;
            }
        }

    }


}
