package com.huiwei.arth.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ϣ������
 */
public class ShellSort {
    public static void main(String[] args) {
       // int[] a = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

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

        shellSort(arr); //����ʽ
        //shellSort1(arr);//��λ��ʽ

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
       // shellSort1(a);
    }

    //������ϣ��
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    //��λ��ϣ��
    public static void shellSort1(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i-gap;
                temp = arr[i];
                while (j >= 0 && temp < arr[j]) {
                    //�ƶ���
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;

            }
        }
     //   System.out.println(Arrays.toString(arr));
    }
}
