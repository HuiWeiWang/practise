package com.huiwei.arth.datastructure.stack;

/**
 * 数组实现栈功能
 */
public class ArrayStack {
    int maxSize;//数组大小
    int[] stack;//数组
    int top = -1;//指针

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
        System.out.println("进行弹出操作");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void push(int data) {
        //1、判断是否已满
        if (isFull()) {
            throw new RuntimeException("栈已满，不能再添加~~~");
        }
        //2、添加
        stack[++top] = data;
    }

    /**
     * 弹出数据
     */
    public int pop() {
        //1、判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈已空，无法弹出数据");
        }
        //弹出数据
        return stack[top--];
    }

    /**
     * 遍历栈
     */
    public void show() {
        if (isEmpty())
            System.out.println("栈已空！不进行遍历~~~");
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }
}
