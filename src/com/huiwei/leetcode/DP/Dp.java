package com.huiwei.leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dp {

   static Map<Integer,Integer> map = new HashMap();

   //直接递归
    public static int fib(int N){
        if(N==1 || N==2) return 1;
        return fib(N-1)+fib(N-2);
    }

    //含备忘录递归
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
    //动态规划
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
     *给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例：
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是4。
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
