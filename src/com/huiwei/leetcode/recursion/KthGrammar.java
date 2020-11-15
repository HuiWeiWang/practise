package com.huiwei.leetcode.recursion;

/**
 * �ڵ�һ������д��һ�� 0����������ÿһ�У���ǰһ���е�0�滻Ϊ01��1�滻Ϊ10��
 * �������� N ������ K�����ص� N ���е� K���ַ�����K��1��ʼ��
 *
 * ����: N = 4, K = 5
 * ���: 1
 *
 * ����:
 * ��һ��: 0
 * �ڶ���: 01
 * ������: 0110
 * ������: 01101001
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
