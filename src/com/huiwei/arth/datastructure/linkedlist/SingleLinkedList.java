package com.huiwei.arth.datastructure.linkedlist;

public class SingleLinkedList {
    //ͷָ��
    private HeroNode head = new HeroNode(0, "", "");

    public static void main(String[] args) {
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list1.addByNo(new HeroNode(1, "�ν�", "��ʱ��"));
        list1.addByNo(new HeroNode(3, "����", "�Ƕ���"));
        list1.addByNo(new HeroNode(6, "6����", "����"));
        list2.addByNo(new HeroNode(4, "�ֳ�", "����ͷ"));
        list2.addByNo(new HeroNode(2, "¬����", "������"));
        list2.addByNo(new HeroNode(5, "5ë��Ŷ", "��һ��"));
        list1.list();
        System.out.println("~~~~~~~~~~");
        list2.list();
        SingleLinkedList merge = list1.merge(list1, list2);
        System.out.println("~~~~�ϲ���~~~~~~");
        merge.list();
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * �ж������Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //���Ԫ�ص�β��
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
     * ɾ������β��Ԫ��
     */
    public HeroNode deleteLast() {
        if(head.getNext() == null){
            System.out.println("�����ѿգ���ɾ��");
            return null;
        }
        HeroNode temp = head.getNext();//ָ�����ڱ���
        HeroNode temp1 = head;//����ָ�����ָ�����һ���ڵ�
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

    //���ձ��˳�����
    public void addByNo(HeroNode node) {
        //��Ϊ��������Ϊ�����ҵ�temp ��λ�� ���λ�õ�ǰһ���ڵ㣬������벻��
        HeroNode temp = head;//����ָ�룬�ر���Ҫ
        while (true) {
            if (temp.getNext() == null || temp.getNext().getNo() > node.getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            } else if (temp.getNext().getNo() == node.getNo()) {
                System.out.println("�ñ�ŵ�Ԫ���Ѿ����ڣ�������ӣ�");
                break;
            }
            temp = temp.getNext();
        }
    }

    //�޸�Ԫ��
    public void update(HeroNode node) {
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("û���ҵ�Ҫ�޸ĵĽڵ�");
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
                System.out.println("û������Ҫɾ����Ԫ��");
                break;
            }
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    //����Ԫ��
    public void list() {
        if (head.getNext() == null) {
            System.out.println("����Ϊ��");
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

    //�������нڵ�ĸ���
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

    //���ҵ������еĵ�����k���ڵ�
    public HeroNode getLast(int k) {
        HeroNode temp = head.getNext();
        for (int i = 1; i < size() - k + 1; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    //������ķ�ת,˼·��

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

    //��β��ͷ��ӡ������(��ʽ1�������������ʽ2��Stackջ)


    //�ϲ�2������ĵ������ϲ�֮���������Ȼ����
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

