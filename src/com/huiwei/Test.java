package com.huiwei;

/**
 * 5 使用单链表存储一个特别大的整数，每个节点存储整数中一位，
 * 头节点表示最高位，尾节点表示最低位，请实现两数相加。
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