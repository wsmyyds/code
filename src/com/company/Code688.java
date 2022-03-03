package com.company;
//在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格
//是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
//
// 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
//
//
//
// 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
//
// 骑士继续移动，直到它走了 k 步或离开了棋盘。
//
// 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
//
//
//
// 示例 1：
//
//
//输入: n = 3, k = 2, row = 0, column = 0
//输出: 0.0625
//解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
//在每一个位置上，也有两种移动可以让骑士留在棋盘上。
//骑士留在棋盘上的总概率是0.0625。
//
//
// 示例 2：
//
//
//输入: n = 1, k = 0, row = 0, column = 0
//输出: 1.00000
//
//
//
//
// 提示:
//
//
// 1 <= n <= 25
// 0 <= k <= 100
// 0 <= row, column <= n
//
// Related Topics 动态规划 👍 168 👎 0

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code688 {

    public static void main(String[] args) {

        //System.out.println(knightProbability1(3,2,0,0));
        System.out.println(knightProbability(8,30,6,4));
        System.out.println(knightProbability1(8,30,6,4));
        Integer u = null;
        System.out.println(u);
        System.out.println(u==null);
    }

    //f[x-1][y+2] f[x-2][y+1]
    //f[x-1][y-2] f[x-2][y-1]
    //f[x+1][y+2] f[x+2][y+1]
    //f[x+1][y-2] f[x+2][y-1]
    //->f[x][y] = (f[x+1][y-2]|f[x+2][y-1]|f[x+1][y+2]|f[x+2][y+1]|f[x-1][y-2]|f[x-2][y-1]|f[x-1][y+2]|f[x-2][y+1])*1/8

    public static double knightProbability(int n, int k, int row, int column) {

        //
        int[][] dir = new int[][]{{1, -2}, {2, -1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};
        //
        double[][][] map = new double[n][n][k + 1];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //
                    if (step == 0) {
                        map[i][j][step] = 1;
                    } else {
                        //
                        for (int[] d :
                                dir) {
                            int x = i + d[0], y = j + d[1];
                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                continue;
                            }
                            map[i][j][step] += map[x][y][step-1]/8;
                        }
                    }
                }
            }
        }
        return map[row][column][k];
    }

    public static double knightProbability1(int n, int k, int row, int column) {

//        if (k == 0){
//            return 1;
//        }
        double[][][] map = new double[n][n][k + 1];
        boolean[][][] visited = new boolean[n][n][k + 1];
//        dfs(row,column,n,k,map,visited);
        return dfs(row,column,n,k,map,visited)/Math.pow(8,k);

    }

    public static double dfs(int x,int y,int n,int step,double[][][] map,boolean[][][] visited){

        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        //先判断越界后判断是否0步
        if (step==0){
//            map[x][y][step] += 1;
//            visited[x][y][step] = true;
            return 1;
        }
        if (visited[x][y][step]){
            return map[x][y][step];
        }

        int twice = 0;
        twice += dfs(x-1,y-2,n,step-1,map,visited);
        twice += dfs(x-2,y-1,n,step-1,map,visited);
        twice += dfs(x-1,y+2,n,step-1,map,visited);
        twice += dfs(x-2,y+1,n,step-1,map,visited);
        twice += dfs(x+1,y+2,n,step-1,map,visited);
        twice += dfs(x+2,y+1,n,step-1,map,visited);
        twice += dfs(x+1,y-2,n,step-1,map,visited);
        twice += dfs(x+2,y-1,n,step-1,map,visited);
        map[x][y][step] = twice;
        visited[x][y][step] = true;
        return twice;
    }

//    public static double knightProbability1(int n, int k, int row, int column) {
//
//        // 表示剩余k步,处于位置ij处在棋盘的概率,
//        Double[][][] cache = new Double[k + 1][n][n];
//        // 最后得到在row,col处于k步在棋盘的概率
//        double live = dfs(row, column, k, n, cache);
//        // 8个方向的k步有8^k种排列
//        double total = Math.pow(8, k);
//
//        return live / total;
//    }
//
//    public static double dfs(int x, int y, int k, int n, Double[][][] cache) {
//        // 越界,概率是0
//        if (x < 0 || y < 0 || x > n - 1 || y > n - 1) {
//            return 0;
//        }
//        // 对于马最后没有步数可以移动情况下,在棋盘的的概率是1
//        if (k == 0) {
//            return 1;
//        }
//
//        if (cache[k][x][y] != null) {
//            return cache[k][x][y];
//        }
//
//        double onBoard = 0;
//        onBoard += dfs(x - 1, y - 2, k - 1, n, cache);
//        onBoard += dfs(x - 1, y + 2, k - 1, n, cache);
//        onBoard += dfs(x + 1, y - 2, k - 1, n, cache);
//        onBoard += dfs(x + 1, y + 2, k - 1, n, cache);
//        onBoard += dfs(x + 2, y - 1, k - 1, n, cache);
//        onBoard += dfs(x - 2, y - 1, k - 1, n, cache);
//        onBoard += dfs(x + 2, y + 1, k - 1, n, cache);
//        onBoard += dfs(x - 2, y + 1, k - 1, n, cache);
//        cache[k][x][y] = onBoard;
//
//        return onBoard;
//    }
}
