package com.huiwei.arth.datastructure.search;

public class BinarySearchNoRecursion {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 7, 10};
        System.out.println(binarySearchNoRecursion(a, 9));
    }

    /**
     * 二分查找非递归算法
     * @param arr
     * @param val
     * @return
     */
    public static int binarySearchNoRecursion(int arr[] , int val){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == val){
                return mid;
            }else if(arr[mid] > val){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
