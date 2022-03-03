package com.company;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code62 {

    public static void main(String[] args) {

        int m = 3, n = 3;
        System.out.println(uniquePaths(m,n));

    }

    //f[0][0] -> f[m-1][n-1]
    //f[1][1] = f[0][1]+f[1][0]
    //i<m j<n f[i][j] = f[i-1][j] + f[i][j-1]
    //j=n-1 f[i][j] = f[i-1][j]
    //i=m-1 f[i][j] = f[i][j-1]

    public static int uniquePaths(int m, int n) {

        int[][] map = new int[m][n];
        map[0][0] = 1;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i > 0 && j > 0) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                } else if (i > 0) {
                    map[i][j] = map[i - 1][j];
                } else if (j > 0) {
                    map[i][j] = map[i][j - 1];
                }
            }
        }
        return map[m-1][n-1];
    }
}
