package com.huiwei.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] indexs = twoSum3(new int[]{1, 3, 2, 7, 5}, 10);
        System.out.println(Arrays.toString(indexs));
    }
    /**
     * （1）map法
     * map求一个数组中2数之和是否等于目标数，如果存在返回2数下标
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSum(int[] arr,int sum){
        if(arr == null || arr.length < 2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            int needKey = sum - arr[i];
            if(map.containsKey(needKey)){
                return new int[]{map.get(needKey),i};
            }else {
                map.put(arr[i],i);
            }
        }
        return null;
    }

    /**
     * （2）暴力法
     * map求一个数组中2数之和是否等于目标数，如果存在返回2数下标
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSum1(int[] arr,int sum){
        if(arr == null || arr.length < 2){
            return null;
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[i] + arr[j] == sum){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * （3）
     * map求一个数组中2数之和是否等于目标数，如果存在返回2数下标
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSum3(int[] arr,int sum){
        if(arr == null || arr.length < 2){
            return null;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int left = arr[0];
        int right = arr.length -1;
        while (left < right){
            if(arr[left] + arr[right] == sum){
                return new int[]{left,right};
            }else if(arr[left] + arr[right] > sum){
                right--;
            }else {
                left++;
            }
        }
        return null;
    }
}
