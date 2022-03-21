package com.company;

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
//
//
// 示例 1:
//
//
//输入: num = 100
//输出: "202"
// 100/7 14 2
// 14/7 2 0
// 2/7 0 2
//
// 示例 2:
//
//
//输入: num = -7
//输出: "-10"
//
//
//
//
// 提示：
//
//
// -10⁷ <= num <= 10⁷
//
// Related Topics 数学 👍 131 👎 0
/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code504 {

    public static void main(String[] args) {

        System.out.println(100/7);
        System.out.println(1/7);
        System.out.println(convertToBase7(7));

    }


    public static String convertToBase7(int num) {

        int res = 0,index = 1;
        while(num!=0){

            res+= ((num%7)*index);
            num = num/7;
            index*=10;
        }

        return String.valueOf(res);
    }
}
