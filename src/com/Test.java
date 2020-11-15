package com;

import com.sun.prism.impl.shape.BasicRoundRectRep;

import java.util.*;

/**
 * You must write a short function that will verify
 * if any given array contains at least one pair of numbers whose sum is a given parameter.
 * The function must receive 2 parameters: the number series to be checked, and the sum to search for.
 * Every possible case must be treated and show message. In case of a solvable array,
 * the message must show the two numbers found. In case of an error,
 * the message must explain the error and why it happened.
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();
        map.put("a","huiwei");
        map.put("a","chenning");
        System.out.println(map);
    }
    public static Map<Integer, Integer> twoSum(int[] arr, int sum) {
        if(arr == null){
            return null;
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <arr.length ; i++) {
            set.add(arr[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set1.contains(arr[i])){
                continue;
            }
            int num = sum - arr[i];
            if (set.contains(num)){
                map.put(arr[i],num);
                set1.add(num);
            }
        }
        return map;
    }

    public static Map<Integer, Integer> twoSum1(int[] arr, int sum) {
        int left = 0;
        int right = arr.length -1;
        int[] temp = new int[arr.length];
        System.arraycopy(arr,0,temp,0,arr.length-1);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        while(left <= right){
            if(temp[left]+temp[right] == sum){
                map.put(temp[left],temp[right]);
                left++;
                right--;
            }else if(temp[left]+temp[right] < sum){
                left++;
            }else {
                right--;
            }
        }
        return map;
    }
}
