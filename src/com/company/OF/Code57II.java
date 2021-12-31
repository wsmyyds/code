package com.company.OF;

import java.util.ArrayList;

/**
 * @program: code
 * @description: 和为s的连续正数序列.java
 * @author:
 * @create:
 **/
//todo
public class Code57II {

    public static void main(String[] args) {

        int target = 9;
        int[][] res = findContinuousSequence(target);
        System.out.println(res);

    }

    public static int[][] findContinuousSequence(int target) {

        ArrayList<int[]> list = new ArrayList<>();
        int i = 1, j = 2;
        while (i < j) {

            int sum = 0;
            int size = 1;
            for (int k = i; k < j; k++) {
                sum += k;
            }
            if (sum < target) {
                j++;
                size++;
            } else if (sum > target) {
                i++;
                size--;
            } else {
                int[] elArray = new int[size];
                for (int k = 0; k < size; k++) {
                    elArray[k] = i+k;
                }
                list.add(elArray);
                j++;
            }

        }
        return new int[][]{list.get(0),list.get(1)};
    }

}
