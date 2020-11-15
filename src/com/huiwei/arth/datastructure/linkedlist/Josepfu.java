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
    //�����ͷָ�룬������
    private Boy first = null;

    public void addBoy(int count){
        if(count <= 0){
            System.out.println("count������");
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
            System.out.println("��������Ϊ��");
        }
        Boy cursor = first;
        while (true){
            System.out.println("������С����"+cursor.no);
            if(cursor.next == first){
                break;
            }
            cursor=cursor.next;
        }
    }

    public void play(int startNo,int countNum){
        System.out.println("��ʼ����Ϸ~~~");
        if(first == null){
            System.out.println("û��С�������ܿ�ʼ��Ϸ");
        }
        //1������һ������ָ��helper������ָ���������β���ڵ�
        Boy helper = first;
        while (true){
            if(helper.next == first){
                break;
            }
            helper = helper.next;
        }

        //2��С������ǰ���ø���ָ��helper���ƶ���startNo-1����
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.next;
        }
        //3��С���������ø���ָ���ƶ�(countNum-1)�Σ�����ָ�����һ���ڵ����Ҫ���ӵ�С��
        while (true){
            if(helper.next == helper){
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                helper = helper.next;
            }
            System.out.println("С��"+helper.next.no+"����");
            helper.next = helper.next.next;
        }
        System.out.println("���һ��С��"+helper.no+"����");
    }
}

class Boy{
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
