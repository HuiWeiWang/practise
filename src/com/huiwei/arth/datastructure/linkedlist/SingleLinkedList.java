package com.huiwei.arth.datastructure.linkedlist;

public class SingleLinkedList {
    //头指针
    private HeroNode head = new HeroNode(0, "", "");

    public static void main(String[] args) {
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list1.addByNo(new HeroNode(1, "宋江", "及时雨"));
        list1.addByNo(new HeroNode(3, "吴用", "智多星"));
        list1.addByNo(new HeroNode(6, "6哈哈", "六子"));
        list2.addByNo(new HeroNode(4, "林冲", "豹子头"));
        list2.addByNo(new HeroNode(2, "卢俊义", "玉麒麟"));
        list2.addByNo(new HeroNode(5, "5毛巾哦", "五一样"));
        list1.list();
        System.out.println("~~~~~~~~~~");
        list2.list();
        SingleLinkedList merge = list1.merge(list1, list2);
        System.out.println("~~~~合并后~~~~~~");
        merge.list();
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //添加元素到尾部
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }


    /**
     * 删除链表尾部元素
     */
    public HeroNode deleteLast() {
        if(head.getNext() == null){
            System.out.println("集合已空，不删除");
            return null;
        }
        HeroNode temp = head.getNext();//指针用于遍历
        HeroNode temp1 = head;//用于指向遍历指针的上一个节点
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            temp1 = temp1.getNext();
        }
        temp1.setNext(null);
        return temp;
    }

    //按照编号顺序添加
    public void addByNo(HeroNode node) {
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;//辅助指针，特别重要
        while (true) {
            if (temp.getNext() == null || temp.getNext().getNo() > node.getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            } else if (temp.getNext().getNo() == node.getNo()) {
                System.out.println("该编号的元素已经存在，不能添加！");
                break;
            }
            temp = temp.getNext();
        }
    }

    //修改元素
    public void update(HeroNode node) {
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("没有找到要修改的节点");
                break;
            }
            if (temp.getNo() == node.getNo()) {
                temp.setName(node.getName());
                temp.setNickname(node.getNickname());
                break;
            }
            temp = temp.getNext();
        }
    }

    public void delete(int no) {
        HeroNode temp = head;

        while (true) {
            if (temp.getNext() == null) {
                System.out.println("没遇到你要删除的元素");
                break;
            }
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    //遍历元素
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //求单链表中节点的个数
    public int size() {
        int count = 0;
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //查找单链表中的倒数第k个节点
    public HeroNode getLast(int k) {
        HeroNode temp = head.getNext();
        for (int i = 1; i < size() - k + 1; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    //单链表的反转,思路：

    public void reverse() {

        HeroNode temp = head.getNext();
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0, "", "");

        while (temp != null) {
            next = temp.getNext();
            temp.setNext(reverseNode.getNext());
            reverseNode.setNext(temp);
            temp = next;
        }
        head.setNext(reverseNode.getNext());
    }

    //

    public void reverse1(){
        HeroNode cur = head.getNext();
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0,"","");

        while (cur != null){
            next = cur.getNext();
            cur.setNext(reverseNode.getNext());
            reverseNode.setNext(cur);
            cur = next;
        }
        head.setNext(reverseNode.getNext());
    }

    //从尾到头打印单链表(方式1：反向遍历；方式2：Stack栈)


    //合并2个有序的单链表，合并之后的链表依然有序
    public SingleLinkedList merge(SingleLinkedList s1, SingleLinkedList s2) {
        SingleLinkedList s = new SingleLinkedList();
        HeroNode temp = s.head;
        HeroNode temp1 = s1.head.getNext();
        HeroNode temp2 = s2.head.getNext();

        while (temp1 != null && temp2 != null) {
            if (temp1.getNo() >= temp2.getNo()) {
                temp.setNext(temp2);
                temp2 = temp2.getNext();
                temp = temp.getNext();
            } else {
                temp.setNext(temp1);
                temp1 = temp1.getNext();
                temp = temp.getNext();
            }
        }
        while (temp1 != null) {
            temp.setNext(temp1);
            temp1 = temp1.getNext();
            temp = temp.getNext();
        }
        while (temp2 != null) {
            temp.setNext(temp2);
            temp2 = temp2.getNext();
            temp = temp.getNext();
        }
        return s;
    }

}

