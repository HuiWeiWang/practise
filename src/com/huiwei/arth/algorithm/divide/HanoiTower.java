package com.huiwei.arth.algorithm.divide;

public class HanoiTower {
    public static void main(String[] args) {
        play(3,'A','B','C');
    }

    public static void play(int number,char a,char b,char c){
        if(number == 1){
            System.out.println("�� 1 ���̴� "+ a + " -> " + c);
        }else {
            //1�����������е����ƶ���b
            play(number-1,a,c,b);
            //2��������������ƶ���c
            System.out.println("�� "+number+" ���̴� "+a+" -> "+c);
            //����������е��̴�b�ƶ���c
            play(number-1,b,a,c);
        }
    }
}
