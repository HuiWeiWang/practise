package com.huiwei.leetcode.recursion;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 2));
    }
    public static int kthGrammar(int N, int K) {
        int i = 0;
        while (K>1){
            i^= (K+1)%2;
            K = (K+1)/2;
        }
        return 0^i;
    }
}
