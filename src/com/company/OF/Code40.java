package com.company.OF;

import java.util.Arrays;

/**
 * @program: code
 * @description: 最小的k个数.java
 * @author:
 * @create:
 **/
public class Code40 {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int[] resNums = getLeastNumbers(nums, 4);
        System.out.println(resNums);

    }

//    public static int[] getLeastNumbers(int[] arr, int k) {
//
//    }

    // TODO: 快排、最小堆

    //70 70
    public static int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == 0) {
            return arr;
        }
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
