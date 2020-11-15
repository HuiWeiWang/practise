package com.huiwei.arth.datastructure.array;

/**
 * 功能：（1）将二维数组转换为稀疏数组；（2）将稀疏数组还原为二维数组
 *
 */
public class SparseArray {

    public static void main(String[] args) {
        //原始二维数组
        //棋盘无棋子默认为0，白子为1，黑子为2
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //打印二维数组
        System.out.println("打印原始二维数组~~~~~~");
        for (int [] line: chessArr) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        ///将二维数组转化为稀疏数组
        int count = 0;
        //1、得到二维数组有效数据大小
        for (int i = 0; i < chessArr.length ; i++) {
            for (int j = 0; j < chessArr[i].length ; j++) {
                if(chessArr[i][j] != 0){
                    count++;
                }
            }
        }
      //  System.out.println(count);

        //2、创建稀疏数组
        int sparseArr[][] = new int[count+1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = count;
        //3、循环遍历二维数组将值赋给稀疏数组
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
        //打印稀疏数组
        System.out.println("打印稀疏数组~~~~~~");
        for (int [] line: sparseArr) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组还原为二维数组
        //1、新建一个二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2、将稀疏数组的值赋给新的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //打印还原后的二维数组
        System.out.println("打印还原后的二维数组~~~~~~");
        for (int [] line: chessArr2) {
            for (int data : line) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
