package com.company.OF;

/**
 * @program: code
 * @description:顺时针打印矩阵.java
 * @author:
 * @create:
 **/
public class Code29 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] arr2 = spiralOrder(arr);
        for (int i : arr2
        ) {
            System.out.println(i);
        }

    }

    public static int[] spiralOrder(int[][] matrix) {

        int r_len = matrix[0].length-1;
        int c_len = matrix.length-1;
        int[] res = new int[(r_len+1) * (c_len+1)];
        int size = 0, i = 0, j = 0, r_s = 0, c_s = 0;

        while (size < res.length) {
            while (j < r_len) {
                res[size++] = matrix[i][j];
                j++;
            }
            if (size == res.length){break;}
            r_s++;
            i = r_s;
            while (i < c_len) {
                res[size++] = matrix[i][j];
                i++;
            }
            if (size == res.length){break;}
            c_len--;
            j = c_len;
            while (j >= r_s) {
                res[size++] = matrix[i][j];
            }
            if (size == res.length){break;}
            r_len--;
            i = r_len;
            while (i >= c_s) {
                res[size++] = matrix[i][j];
            }

        }

        return res;
    }
}
