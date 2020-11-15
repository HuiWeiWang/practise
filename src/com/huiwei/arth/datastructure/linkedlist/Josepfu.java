package com.huiwei.arth.datastructure.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(10);
        list.show();
        list.play(1,3);
    }



}

class CircleSingleLinkedList{
    //这个是头指针，必须有
    private Boy first = null;

    public void addBoy(int count){
        if(count <= 0){
            System.out.println("count数不对");
        }
        Boy cursor = null;
        for (int i = 1; i <= count ; i++) {
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.next=first;
                cursor = first;
            }else {
                cursor.next = boy;
                boy.next=first;
                cursor=boy;
            }
        }
    }

    public void show(){
        if (first == null){
            System.out.println("环形链表为空");
        }
        Boy cursor = first;
        while (true){
            System.out.println("遍历到小孩："+cursor.no);
            if(cursor.next == first){
                break;
            }
            cursor=cursor.next;
        }
    }

    public void play(int startNo,int countNum){
        System.out.println("开始玩游戏~~~");
        if(first == null){
            System.out.println("没有小孩，不能开始游戏");
        }
        //1、创建一个辅助指针helper，事先指向环形链表的尾部节点
        Boy helper = first;
        while (true){
            if(helper.next == first){
                break;
            }
            helper = helper.next;
        }

        //2、小孩报数前，让辅助指针helper先移动（startNo-1）次
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.next;
        }
        //3、小孩报数，让辅助指针移动(countNum-1)次，则辅助指针的下一个节点就是要出队的小孩
        while (true){
            if(helper.next == helper){
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                helper = helper.next;
            }
            System.out.println("小孩"+helper.next.no+"出列");
            helper.next = helper.next.next;
        }
        System.out.println("最后一个小孩"+helper.no+"出列");
    }
}

class Boy{
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
