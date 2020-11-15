package com.huiwei.leetcode.exam;

import java.util.Arrays;

/**
 * �����ڿ�������ִ��һ�ο�������֮��ÿ��ֻѡ��һ���ּ���ִ�п�������
 * ֱ���ҵ���K���Ԫ��Ϊֹ�����Ԫ��������λ�ú����Ԫ�ؼ�Ϊ����
 *
 * ʱ�临�Ӷȣ�O��n��
 *
 * ���ÿ��ŵ�˼�룬������arr������ҳ�һ��Ԫ��X��������ֳ�������arr_a��arr_b��
 *
 * arr_a�е�Ԫ�ر�x��arr_b�е�Ԫ�ر�xС��
 *
 * ���ʱ���Ϊ���������
 *
 * 1.arr_a�е�Ԫ��С��K����arr_b�е�k-arr_a.length��Ԫ�ؼ�Ϊ��K������
 *
 * 2.arr_a�е�Ԫ�ش��ڵ���K���򷵻�arr_a�е�K����
 */
public class FindNMax {
    public static int partition(int[] arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            while(arr[high]<=temp&&high>low)
                --high;
            arr[low]=arr[high];
            while(arr[low]>=temp&&low<high)
                ++low;
            arr[high]=arr[low];
        }
        arr[high]=temp;
        return high;
    }
    public static void find_k(int k,int[] arr,int low,int high){
        int temp=partition(arr,low,high);
        if(temp==k-1){
            System.out.print("��"+k+"������ǣ�"+arr[temp]);
        }else if(temp>k-1){
            find_k(k,arr,low,temp-1);
        }else{
            find_k(k-temp,arr,temp+1,high);
        }
    }


    public static void main(String[] args) {
        int[] arr={3,1,2,5,4,7,6};
        find_k(2,arr,0,arr.length-1);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

}
