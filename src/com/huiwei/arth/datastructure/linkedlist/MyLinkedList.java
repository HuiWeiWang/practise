package com.huiwei.arth.datastructure.linkedlist;

public class MyLinkedList {
    private Node1 head = new Node1();
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(new Node1(1));
        linkedList.add(new Node1(2));
        linkedList.add(new Node1(3));
        linkedList.add(new Node1(4));
        linkedList.add(new Node1(5));
        linkedList.show();
        linkedList.reverse();
        System.out.println("链表反转~~~~~~~~~~~");
        linkedList.show();
    }

    public void add(Node1 node){
        Node1 temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.setNext(node);
    }

    public void show(){
        if(head.getNext()==null){
            System.out.println("你要遍历的链表为空");
            return;
        }
        Node1 temp = head.next;
        while(temp!=null){
            System.out.println(temp.getNo());
            if(temp.getNext()!=null){
                temp=temp.getNext();
            }else {
                return;
            }
        }
    }

    /**
     * 单链表反转
     */
    public void reverse(){
        Node1 temp = head.getNext();
        Node1 next = null;
        Node1 newNode = new Node1();
        while (temp!=null){
            next = temp.getNext();
            temp.setNext(newNode.getNext());
            newNode.setNext(temp);
            temp=next;
        }
        head.setNext(newNode.getNext());
    }

}


class Node1{
    int no;
    Node1 next;

    public Node1() {
    }

    public Node1(int no) {
        this.no = no;
    }

    public Node1(int no, Node1 next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }
}