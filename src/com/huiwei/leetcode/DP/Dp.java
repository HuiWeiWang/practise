package com.huiwei.leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dp {

   static Map<Integer,Integer> map = new HashMap();

   //ֱ�ӵݹ�
    public static int fib(int N){
        if(N==1 || N==2) return 1;
        return fib(N-1)+fib(N-2);
    }

    //������¼�ݹ�
    public static int fibWithMemo(int N){
        if(N==1 || N==2) return 1;

        if(map.containsKey(N)){
            return map.get(N);
        }else {
            int value = fib(N-1)+fib(N-2);
            map.put(N,value);
            return value;
        }
    }
    //��̬�滮
    public static int dp(int N){
        if(N==1 || N==2) return 1;
        int a = 1;
        int b =1;
        int temp=0;
        for (int i = 3; i <=N ; i++) {
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }

    /**
     *����һ��������������飬�ҵ���������������еĳ��ȡ�
     *
     * ʾ����
     *
     * ����: [10,9,2,5,3,7,101,18]
     * ���: 4
     * ����: ��������������� [2,3,7,101]�����ĳ�����4��
     *
     */

    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        int res=0;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }



    public static void main(String[] args) {
       int[] dp = new int[]{10,9,2,5,3,7,101,18};
        int length = lengthOfLIS(dp);
        System.out.println(length);
    }
}
