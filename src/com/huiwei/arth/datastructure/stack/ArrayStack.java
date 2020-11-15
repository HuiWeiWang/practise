package com.huiwei.arth.datastructure.stack;

/**
 * ����ʵ��ջ����
 */
public class ArrayStack {
    int maxSize;//�����С
    int[] stack;//����
    int top = -1;//ָ��

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.show();
        System.out.println("���е�������");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }

    /**
     * �ж�ջ�Ƿ���
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * �ж�ջ�Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * �������
     *
     * @param data
     */
    public void push(int data) {
        //1���ж��Ƿ�����
        if (isFull()) {
            throw new RuntimeException("ջ���������������~~~");
        }
        //2�����
        stack[++top] = data;
    }

    /**
     * ��������
     */
    public int pop() {
        //1���ж�ջ�Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("ջ�ѿգ��޷���������");
        }
        //��������
        return stack[top--];
    }

    /**
     * ����ջ
     */
    public void show() {
        if (isEmpty())
            System.out.println("ջ�ѿգ������б���~~~");
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }
}
