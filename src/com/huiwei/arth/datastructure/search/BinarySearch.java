package com.huiwei.arth.datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 7, 10,10};
        //Arrays.sort(a);
        System.out.println(binarySearchAll(a, 0, a.length - 1, 10));
    }

    /**
     * 查找第一个找到的元素
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int val) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] > val) {
            return binarySearch(arr, left, mid - 1, val);
        } else {
            return binarySearch(arr, mid + 1, right, val);
        }
    }

    /**
     * 查找所有找到的元素
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static List<Integer> binarySearchAll(int[] arr, int left, int right, int val) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == val) {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == val) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == val) {
                list.add(temp);
                temp++;
            }
            return list;
        } else if (arr[mid] > val) {
            return binarySearchAll(arr, left, mid - 1, val);
        } else {
            return binarySearchAll(arr, mid + 1, right, val);
        }
    }
}
