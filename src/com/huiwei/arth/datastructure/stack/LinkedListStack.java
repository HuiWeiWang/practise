package com.huiwei.arth.datastructure.stack;

import com.huiwei.arth.datastructure.linkedlist.HeroNode;
import com.huiwei.arth.datastructure.linkedlist.SingleLinkedList;

/**
 * ������ʵ��ջ����
 */
public class LinkedListStack {
    SingleLinkedList stack;

    public LinkedListStack(SingleLinkedList stack) {
        this.stack = stack;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(new SingleLinkedList());
        stack.push(new HeroNode(1, "�ν�", "��ʱ��"));
        stack.push(new HeroNode(3, "����", "�Ƕ���"));
        stack.push(new HeroNode(6, "6����", "����"));
        stack.show();
        System.out.println("�������ݺ�");
        stack.pop();
        stack.pop();
        stack.show();
    }

    /**
     * �������
     *
     * @param data
     */
    public void push(HeroNode data) {
        //2�����
        stack.add(data);
    }

    /**
     * ��������
     */
    public HeroNode pop() {
        //1���ж�ջ�Ƿ�Ϊ��
        if (stack.isEmpty()) {
            throw new RuntimeException("ջ�ѿգ��޷���������");
        }
        //��������
        return stack.deleteLast();
    }

    /**
     * ����ջ
     */
    public void show() {
        stack.list();
    }

}
