package com;

import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 3, 8, 1, 2, 7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] > temp){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }


}
