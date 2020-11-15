package com.huiwei.arth.datastructure.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 100 ; i++) {
            arr[i] = i+1;
        }
        System.out.println(binarySearch(arr, 0, arr.length - 1, 78));
    }

    /**
     * ��ֵ����
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int val){
        System.out.println("��ֵ����~~~");
        if(left > right || val < arr[0] || val > arr[arr.length-1]){
            return  -1;
        }

        //��ֵ�����м�ֵ�Ĺ�ʽ
        int mid = left + (right-left)*(val - arr[left])/(arr[right]-arr[left]);

        if(arr[mid] == val){
            return mid;
        }else if (arr[mid] > val){
            return insertValueSearch(arr,left,mid -1,val);
        }else {
            return insertValueSearch(arr,mid+1,right,val);
        }
    }

    /**
     * ���ֲ���
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int val){
        System.out.println("���ֲ���~~~");
        if(left > right || val < arr[0] || val > arr[arr.length-1]){
            return  -1;
        }

        //��ֵ�����м�ֵ�Ĺ�ʽ
        int mid = (left+right)/2;

        if(arr[mid] == val){
            return mid;
        }else if (arr[mid] > val){
            return binarySearch(arr,left,mid -1,val);
        }else {
            return binarySearch(arr,mid+1,right,val);
        }
    }
}
