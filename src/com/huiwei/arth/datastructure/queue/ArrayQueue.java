package com.huiwei.arth.datastructure.queue;

public class ArrayQueue<E> {
    private int maxSize;
    private static int front;
    private static int tail;
    private Object[] DATA;

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(5);
        System.out.println(arrayQueue.getQueue());
        System.out.println(front);
        System.out.println(arrayQueue.getHead());
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.DATA = new Object[maxSize];
    }
    //�����Ƿ�Ϊ��
    public boolean isEmpty() {
        return front == tail;
    }
    //�����Ƿ�����
    public boolean isFull() {
        return tail == maxSize;
    }

    //��ӵ�����
    public boolean addQueue(E e) {
        if (isFull()) {
            throw new RuntimeException("���������������������~~~");
        }
        DATA[tail++] = e;
        return true;
    }
    //�Ӷ�����ȡ��
    public Object getQueue(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿգ��޷�ȡ����~~~");
        }
        return DATA[front++];
    }

    //ѭ����������
    public  void show(){
        for (int i = front; i <= tail; i++) {
            System.out.println(DATA[i]);
        }
    }

    //չʾͷ����
    public Object getHead(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿգ��޷�ȡ����~~~");
        }
        return DATA[front];
    }

}

