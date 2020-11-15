package com.huiwei.arth.datastructure.stack;

import com.huiwei.arth.datastructure.linkedlist.HeroNode;
import com.huiwei.arth.datastructure.linkedlist.SingleLinkedList;

/**
 * 单链表实现栈功能
 */
public class LinkedListStack {
    SingleLinkedList stack;

    public LinkedListStack(SingleLinkedList stack) {
        this.stack = stack;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(new SingleLinkedList());
        stack.push(new HeroNode(1, "宋江", "及时雨"));
        stack.push(new HeroNode(3, "吴用", "智多星"));
        stack.push(new HeroNode(6, "6哈哈", "六子"));
        stack.show();
        System.out.println("弹出数据后");
        stack.pop();
        stack.pop();
        stack.show();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void push(HeroNode data) {
        //2、添加
        stack.add(data);
    }

    /**
     * 弹出数据
     */
    public HeroNode pop() {
        //1、判断栈是否为空
        if (stack.isEmpty()) {
            throw new RuntimeException("栈已空，无法弹出数据");
        }
        //弹出数据
        return stack.deleteLast();
    }

    /**
     * 遍历栈
     */
    public void show() {
        stack.list();
    }

}
