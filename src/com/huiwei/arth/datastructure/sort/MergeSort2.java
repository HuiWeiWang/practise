package com.huiwei.arth.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int [] a = new int[]{10,3,8,1,2,7};
        //用来临时存放数据
        int[] temp = new int[a.length];

        mergeSort(a,0,a.length-1,temp);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if(left < right){
            int index = (left+right)/2;
            mergeSort(arr,left,index,temp);
            mergeSort(arr,index+1,right,temp);
            merge(arr,left,index,right,temp);
        }
    }

    private static void merge(int[] arr, int left, int index, int right, int[] temp) {
        int i = left;
        int j = index+1;
        int tem = 0;
        while (i <= index && j <= right){
            if(arr[i] <= arr[j]){
                temp[tem] = arr[i];
                i++;
                tem++;
            }
            if (arr[i] > arr[j]) {
                temp[tem] = arr[j];
                j++;
                tem++;
            }
        }

        while (i <= index){
            temp[tem] = arr[i];
            i++;
            tem++;
        }
        while (j <= right){
            temp[tem] = arr[j];
            j++;
            tem++;
        }

        tem = 0;
        while (left<=right){
            arr[left] = temp[tem];
            left++;
            tem++;
        }
    }
}
