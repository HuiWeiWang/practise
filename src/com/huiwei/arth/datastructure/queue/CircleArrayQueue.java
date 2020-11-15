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
    //队列是否为空
    public boolean isEmpty() {
        return front == tail;
    }
    //队列是否已满
    public boolean isFull() {
        return (tail+1) % maxSize == front;
    }

    //添加到队列
    public boolean addQueue(E e) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能添加数据~~~");
        }
        DATA[tail] = e;
        tail = (tail+1) % maxSize;
        return true;
    }
    //从队列中取出
    public Object getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取数据~~~");
        }
        Object value = DATA[front];
        front = (front+1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, DATA[i % maxSize]);
        }
    }

    //展示头数据
    public Object getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取数据~~~");
        }
        return DATA[front];
    }

    //获取队列有效数据长度
    public int size(){
        return (tail+maxSize-front) % maxSize;
    }
}
