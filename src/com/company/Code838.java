package com.company;
//n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
//
// 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
//
// 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
//
// 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
//
//
// dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
// dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
// dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
//
//
// 返回表示最终状态的字符串。
//
//
// 示例 1：
//
//
//输入：dominoes = "RR.L"
//输出："RR.L"
//解释：第一张多米诺骨牌没有给第二张施加额外的力。
//
//
// 示例 2：
//
//
//输入：dominoes = ".L.R...LR..L.."
//输出："LL.RR.LLRRLL.."
//
//
//
//
// 提示：
//
//
// n == dominoes.length
// 1 <= n <= 10⁵
// dominoes[i] 为 'L'、'R' 或 '.'
//
// Related Topics 双指针 字符串 动态规划 👍 155 👎 0
/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Code838 {

    public static void main(String[] args) {

        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }

    public static String pushDominoes(String dominoes) {

        char[] arr = dominoes.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i]=='.'){
                int index1=i,index2=i;
                char pre='.',end='.';
                while ((pre=='.'&&index1-1>0)||(end=='.'&&index2+1<arr.length-1)){
                    if (index1-1>0){
                        if (arr[index1-1]=='.'){
                            index1 = index1-1;
                            continue;
                        }else if (arr[index1-1]=='R'){
                            pre = 'R';
                        }else {
                            pre = 'L';
                        }
                    }
                    if (index2+1<arr.length-1){
                        if (arr[index2+1]=='.'){
                            index2 = index2-1;
                            continue;
                        }else if (arr[index2+1]=='R'){
                            end = 'R';
                        }else {
                            end = 'L';
                        }
                    }
                }
                if (pre==end){
                    while (index1<index2){
                        arr[index1]=pre;
                        index1++;
                    }
                }
                if (pre=='R'&&end=='L'){
                    while (index1<index2){
                        if (index1<i){
                            arr[index1]=pre;
                            index1++;
                        }
                        if (index2>i){
                            arr[index2]=end;
                            index2--;
                        }
                        arr[i]='.';
                    }
                }
            }

        }
        return new String(arr);

    }
}
