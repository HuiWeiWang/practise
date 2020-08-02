package com.huiwei.juc.threadlocal;

public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父线程变量");
        System.out.println(Thread.currentThread().getName()+"拿到线程本地变量:"+threadLocal.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"拿到线程本地变量:"+threadLocal.get());
            }
        }).start();
    }
}

