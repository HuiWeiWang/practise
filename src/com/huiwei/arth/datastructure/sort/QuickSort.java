package com.huiwei.arth.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 3, 8, 1, 2, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("�����:");
        System.out.println(Arrays.toString(arr));
        // ����Ҫ��80000�������������
     /*   int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = (int) (Math.random() * 100000000); // ����һ��[0, 8000000) ��
        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);*/

        //shellSort(arr); //����ʽ
     /*   quickSort(arr,0,arr.length-1);//��λ��ʽ

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);*/
    }

    /**
     * ��������
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // ��Ѱ��׼���ݵ���ȷ����
            int index = getIndex(arr, low, high);

            // ���е�����index֮ǰ��֮������������ͬ�Ĳ���ʹ��������������
            //quickSort(arr, 0, index - 1); ֮ǰ�İ汾�����������кܴ���������⣬лл��ҵĽ���
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);

        }

    }

    /**
     * ��ȡ��׼����λ��
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getIndex(int[] arr, int low, int high) {
        // ��׼����
        int tmp = arr[low];
        while (low < high) {
            // ����β��Ԫ�ش��ڵ��ڻ�׼����ʱ,��ǰŲ��highָ��
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // �����βԪ��С��tmp��,��Ҫ���丳ֵ��low
            arr[low] = arr[high];
            // ������Ԫ��С�ڵ���tmpʱ,��ǰŲ��lowָ��
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // ������Ԫ�ش���tmpʱ,��Ҫ���丳ֵ��high
            arr[high] = arr[low];

        }
        // ����ѭ��ʱlow��high���,��ʱ��low��high����tmp����ȷ����λ��
        // ��ԭ���ֿ��Ժ������֪��lowλ�õ�ֵ������tmp,������Ҫ��tmp��ֵ��arr[low]
        arr[low] = tmp;
        return low; // ����tmp����ȷλ��
    }
}
