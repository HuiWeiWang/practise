package com.huiwei.arth.datastructure.linkedlist;

public class DoubleLinkedList {
    private static Node head;

    public static void main(String[] args) {
        addNode(new Node(1, "小王"));
        addNode(new Node(2, "小李"));
        addNode(new Node(3, "小周"));
        show();
        deleteNode(1);
        deleteNode(3);
        deleteNode(2);
        System.out.println("删除后~~~~~~~~~");
        show();

    }

    /**
     * 添加节点
     *
     * @param newNode
     */
    public static void addNode(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        //辅助指针
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
     * 遍历链表
     */
    public static void show() {
        Node cursor = head;
        if (cursor == null) {
            System.out.println("链表为空");
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
     * 删除节点
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
                System.out.println("没有找到你要删除的节点");
                return;
            }
            if (cursor.getNo() == no) {
                System.out.println("找到删除节点，即将删除");
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