package com.huiwei.arth.algorithm.dynamicdesign;

import java.util.Arrays;

public class Package {

    public static void main(String[] args) {
        int totalWeight = 10;                    //��Ʒ��������������
        Bean[] data = new Bean[]{new Bean(0, 0),
                new Bean(2, 6), new Bean(2, 3), new Bean(6, 5), new Bean(5, 4), new Bean(4, 6)};
        System.out.println(getMaxValue(data, totalWeight));
    }

    public static int getMaxValue(Bean[] data, int totalWeight) {
        int n = data.length;
        int[][] table = new int[n][totalWeight + 1];
        for (int i = 1; i < n; i++) { //��Ʒ
            for (int w = 1; w <= totalWeight; w++) {  //������С
                if (data[i].weight > w) {
                    //��ǰ��Ʒi�������ȱ�������j��װ���£��϶����ǲ�װ
                    table[i][w] = table[i - 1][w];
                } else { //װ���£�Max{װ��Ʒi�� ��װ��Ʒi}
                    table[i][w] = Math.max(table[i - 1][w], table[i - 1][w - data[i].weight] + data[i].value);
                }
            }
        }
        for (int f = 0; f < table.length; f++) {
            System.out.println(Arrays.toString(table[f]));
        }
        return table[n - 1][totalWeight];
    }

    static class Bean {
        int weight = 0;
        int value = 0;

        Bean(int w, int v) {
            weight = w;
            value = v;
        }

        @Override
        public String toString() {
            return weight + "  " + value;
        }
    }

}
