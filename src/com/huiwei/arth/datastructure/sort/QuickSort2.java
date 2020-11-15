package com.huiwei.arth.datastructure.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {10, 3, 8, 1, 2, 7};
        selectSort(arr);
        System.out.println("≈≈–Ú∫Û:");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        int temp =0;
        for (int i = 0; i < arr.length ; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            int j = i-1;
            int value = arr[i];
            while (j>=0&&arr[j]>value){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=value;
        }
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static  void quickSort(int[] arr,int low,int high){
        if(low < high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
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
