package com.huiwei;

/**
 * 5 ʹ�õ�����洢һ���ر���������ÿ���ڵ�洢������һλ��
 * ͷ�ڵ��ʾ���λ��β�ڵ��ʾ���λ����ʵ��������ӡ�
 */
public class Test {
    Node head;
    public static void main(String[] args) {

    }

    public void add(Node node){
        Node cur = head.next;
        if(head.next == null){
            head.next = node;
        }else {

        }
    }
}


class Node{
    int number;
    Node next;

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}