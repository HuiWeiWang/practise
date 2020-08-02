package com.huiwei.arth.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * �鲢����
 */
public class MergeSort {
    public static void main(String[] args) {
     /*   int[] arr = new int[]{10, 3, 8, 1, 2, 7,34,12,53,3,10};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));*/
        // ����Ҫ��80000�������������
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 100000); // ����һ��[0, 8000000) ��
        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }

    /**
     * �鲢����
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int arr[],int left,int right,int[] temp){

        if(left < right){

            int mid = (left+right)/2;
            //�ݹ�ֽ����
            mergeSort(arr,left,mid,temp);
            //�ݹ�ֽ��ұ�
            mergeSort(arr,mid+1,right,temp);
            //�ֽ���֮��ϲ�
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * �ϲ�����
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
        //1���Ȱ��������ߵ��������ηŵ�temp�����У�ֱ����һ�߷���Ϊֹ
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

        //2������ʣ���Ǳߵ�ʣ��Ԫ�طŽ���ʱ������
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
        //3������ʱ�����е����ݿ�����ԭ����
        tep = 0;
        while (left <= right){
            arr[left] = temp[tep];
            left++;
            tep++;
        }
    }
}
