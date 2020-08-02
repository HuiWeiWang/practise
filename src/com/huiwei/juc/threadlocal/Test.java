package com.huiwei.juc.threadlocal;

public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("���̱߳���");
        System.out.println(Thread.currentThread().getName()+"�õ��̱߳��ر���:"+threadLocal.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"�õ��̱߳��ر���:"+threadLocal.get());
            }
        }).start();
    }
}

