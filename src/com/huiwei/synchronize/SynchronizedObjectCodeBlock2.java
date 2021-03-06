package com.huiwei.synchronize;

/**
 * 对象锁示例1，代码块形式
 * 锁有两种用法：this和构造一个
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {
    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是对象锁的代码块形式，我叫：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

      /*  synchronized (lock2) {
            System.out.println("我是对象锁的代码块形式，我叫：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }*/
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //使用一个空循环，保证t1和t2执行完再进行打印
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
