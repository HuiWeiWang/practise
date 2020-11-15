package com.huiwei.arth.datastructure.array;

/**
 * ���ܣ���1������ά����ת��Ϊϡ�����飻��2����ϡ�����黹ԭΪ��ά����
 *
 */
public class SparseArray {

    public static void main(String[] args) {
        //ԭʼ��ά����
        //����������Ĭ��Ϊ0������Ϊ1������Ϊ2
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //��ӡ��ά����
        System.out.println("��ӡԭʼ��ά����~~~~~~");
        for (int [] line: chessArr) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        ///����ά����ת��Ϊϡ������
        int count = 0;
        //1���õ���ά������Ч���ݴ�С
        for (int i = 0; i < chessArr.length ; i++) {
            for (int j = 0; j < chessArr[i].length ; j++) {
                if(chessArr[i][j] != 0){
                    count++;
                }
            }
        }
      //  System.out.println(count);

        //2������ϡ������
        int sparseArr[][] = new int[count+1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = count;
        //3��ѭ��������ά���齫ֵ����ϡ������
        int count1 = 0;
        for (int i = 0; i < chessArr.length ; i++) {
            for (int j = 0; j < chessArr[i].length ; j++) {
                if(chessArr[i][j] != 0){
                    count1++;
                    sparseArr[count1][0] = i;
                    sparseArr[count1][1] = j;
                    sparseArr[count1][2] = chessArr[i][j];
                }
            }
        }
        //��ӡϡ������
        System.out.println("��ӡϡ������~~~~~~");
        for (int [] line: sparseArr) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //��ϡ�����黹ԭΪ��ά����
        //1���½�һ����ά����
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2����ϡ�������ֵ�����µĶ�ά����
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //��ӡ��ԭ��Ķ�ά����
        System.out.println("��ӡ��ԭ��Ķ�ά����~~~~~~");
        for (int [] line: chessArr2) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
