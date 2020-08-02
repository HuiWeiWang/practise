package com.huiwei.arth.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
     /*   int[] arr = new int[]{10, 3, 8, 1, 2, 7,34,12,53,3,10};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));*/
        // 创建要给80000个的随机的数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 100000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int arr[],int left,int right,int[] temp){

        if(left < right){

            int mid = (left+right)/2;
            //递归分解左边
            mergeSort(arr,left,mid,temp);
            //递归分解右边
            mergeSort(arr,mid+1,right,temp);
            //分解完之后合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并过程
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int arr[], int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int tep = 0;
        //1、先把左右两边的数据依次放到temp数组中，直到有一边放完为止
        while (i <= mid && j <= right){
            if(arr[i]<=arr[j]){
                temp[tep] = arr[i];
                tep++;
                i++;
            }else {
                temp[tep] = arr[j];
                tep++;
                j++;
            }
        }

        //2、将有剩余那边的剩余元素放进临时数组中
        while (i <= mid){
            temp[tep] = arr[i];
            tep++;
            i++;
        }
        while (j <= right){
            temp[tep] = arr[j];
            tep++;
            j++;
        }
        //3、将临时数组中的数据拷贝回原数组
        tep = 0;
        while (left <= right){
            arr[left] = temp[tep];
            left++;
            tep++;
        }
    }
}
