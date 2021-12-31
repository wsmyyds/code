package com.company.OF;

/**
 * @program: code
 * @description:旋转数组的最小数字.java
 * @author:
 * @create:
 **/
public class Code11 {

    public static void main(String[] args) {

        int[] arr =new int[]{3,4,5,1,2};
        //System.out.println(arr.length/2);
        System.out.println(minArray(arr));
    }

    public static int minArray(int[] numbers) {

        //1,2,3,4,5,6
        //4 5 6 1 2 3
        //4 6 3
        //
        //1,2,3,4,5,6
        //5 6 1 2 3 4
        //5 1 4
        //
        //
        //2 2 2 2
        //2 2 2 2
        int i = 0;
        int j = numbers.length-1;
        while (i < j) {
            int m = (i+j)/2;
            if (numbers[m] < numbers[j]){
                j = m;
            }else if (numbers[m]>numbers[j]){
                i = m+1;
            }else {
                j--;
            }
        }
        return numbers[i];
    }

    //100 51
    public static int minArrayOld(int[] numbers) {

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]<res){
                res = numbers[i];
            }
        }

        return res;
    }


}
