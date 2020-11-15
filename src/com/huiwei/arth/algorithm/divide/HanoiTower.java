package com.huiwei.arth.algorithm.divide;

public class HanoiTower {
    public static void main(String[] args) {
        play(3,'A','B','C');
    }

    public static void play(int number,char a,char b,char c){
        if(number == 1){
            System.out.println("第 1 个盘从 "+ a + " -> " + c);
        }else {
            //1、将上面所有的盘移动到b
            play(number-1,a,c,b);
            //2、将最下面的盘移动到c
            System.out.println("第 "+number+" 个盘从 "+a+" -> "+c);
            //将上面的所有的盘从b移动到c
            play(number-1,b,a,c);
        }
    }
}
