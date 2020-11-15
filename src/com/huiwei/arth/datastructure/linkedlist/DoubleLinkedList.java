package com.huiwei.arth.datastructure.linkedlist;

public class DoubleLinkedList {
    private static Node head;

    public static void main(String[] args) {
        addNode(new Node(1, "С��"));
        addNode(new Node(2, "С��"));
        addNode(new Node(3, "С��"));
        show();
        deleteNode(1);
        deleteNode(3);
        deleteNode(2);
        System.out.println("ɾ����~~~~~~~~~");
        show();

    }

    /**
     * ��ӽڵ�
     *
     * @param newNode
     */
    public static void addNode(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        //����ָ��
        Node cursor = head;
        while (true) {
            if (cursor.getNext() == null) {
                break;
            }
            cursor = cursor.getNext();
        }
        cursor.setNext(newNode);
        newNode.setPre(cursor);
    }

    /**
     * ��������
     */
    public static void show() {
        Node cursor = head;
        if (cursor == null) {
            System.out.println("����Ϊ��");
            return;
        }
        while (true) {
            if (cursor == null) {
                break;
            }
            System.out.println(cursor.getNo() + "====" + cursor.getName());
            cursor = cursor.getNext();
        }

    }

    /**
     * ɾ���ڵ�
     *
     * @param no
     */
    public static void deleteNode(int no) {
        Node cursor = head;
        if (head.getNo() == no) {
            head = head.getNext();
            return;
        }
        while (true) {
            if (cursor == null) {
                System.out.println("û���ҵ���Ҫɾ���Ľڵ�");
                return;
            }
            if (cursor.getNo() == no) {
                System.out.println("�ҵ�ɾ���ڵ㣬����ɾ��");
                cursor.getPre().setNext(cursor.getNext());
                if(cursor.getNext() != null)
                cursor.getNext().setPre(cursor.getPre());
                return;
            }
            cursor = cursor.getNext();
        }
    }
}


class Node {

    private int no;
    private String name;
    private Node pre;
    private Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}