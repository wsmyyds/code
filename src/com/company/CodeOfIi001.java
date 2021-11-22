package com.company;

/**
 * @program: code
 * @description: ✔[剑指 Offer II 001]整数除法
 * @author:
 * @create:
 **/
public class CodeOfIi001 {

//    int a = -2147483648;
//    int b = 2;
//    System.out.println(divide(a, b));

    public static int divide(int a, int b) {

        byte sign = 0;
        if (a == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1)
        {return Integer.MAX_VALUE;}
        if (a < 0 || b < 0) {
            if (!(a < 0 && b < 0)) {
                sign = 1;
            }
        }

        if (a>0){a=-a;}
        if (b>0){b=-b;}

        int end = 0;
        while(a<=b) {

            a = a - b;
            end++;
        }

        return sign == 0 ? end : -end;
    }
}
