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
    //队列是否为空
    public boolean isEmpty() {
        return front == tail;
    }
    //队列是否已满
    public boolean isFull() {
        return tail == maxSize;
    }

    //添加到队列
    public boolean addQueue(E e) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能添加数据~~~");
        }
        DATA[tail++] = e;
        return true;
    }
    //从队列中取出
    public Object getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取数据~~~");
        }
        return DATA[front++];
    }

    //循环遍历数据
    public  void show(){
        for (int i = front; i <= tail; i++) {
            System.out.println(DATA[i]);
        }
    }

    //展示头数据
    public Object getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取数据~~~");
        }
        return DATA[front];
    }

}

