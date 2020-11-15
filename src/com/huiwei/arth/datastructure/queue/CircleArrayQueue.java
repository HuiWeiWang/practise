package com.huiwei.arth.datastructure.queue;

public class CircleArrayQueue<E> {
    private int maxSize;
    private static int front;
    private static int tail;
    private Object[] DATA;
    public static void main(String[] args) {

    }
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.DATA = new Object[maxSize];
    }
    //�����Ƿ�Ϊ��
    public boolean isEmpty() {
        return front == tail;
    }
    //�����Ƿ�����
    public boolean isFull() {
        return (tail+1) % maxSize == front;
    }

    //��ӵ�����
    public boolean addQueue(E e) {
        if (isFull()) {
            throw new RuntimeException("���������������������~~~");
        }
        DATA[tail] = e;
        tail = (tail+1) % maxSize;
        return true;
    }
    //�Ӷ�����ȡ��
    public Object getQueue(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿգ��޷�ȡ����~~~");
        }
        Object value = DATA[front];
        front = (front+1) % maxSize;
        return value;
    }

    // ��ʾ���е���������
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("���пյģ�û������~~");
            return;
        }
        // ˼·����front��ʼ�������������ٸ�Ԫ��
        // ���Խ�
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, DATA[i % maxSize]);
        }
    }

    //չʾͷ����
    public Object getHead(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿգ��޷�ȡ����~~~");
        }
        return DATA[front];
    }

    //��ȡ������Ч���ݳ���
    public int size(){
        return (tail+maxSize-front) % maxSize;
    }
}
