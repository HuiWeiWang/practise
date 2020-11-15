package com.huiwei.arth.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
      //  int [] a = new int[]{10,3,8,1,2,7};
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

        //shellSort(arr); //交换式
        inserSort(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        //inserSort(a);
    }

    /**
     * 插入排序
     * @param array
     */
    private static void inserSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value){
                array[j+1] = array[j];
                j--;
            }
            //假设一次都没有移动，直接放在第二个
            array[j+1]=value;
        }
      //  System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length ; i++) {
            int j = i -1;
            int value = array[i];
            while (j >= 0 && array[j] > value){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = value;
        }
    }
}
