package com.huiwei.juc.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/4/1 16:03
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new DeadThread(lockA,lockB),"aaa").start();
        new Thread(new DeadThread(lockB,lockA),"aaa").start();
    }

}

class DeadThread implements Runnable{
    String lockA ;
    String lockB ;

    public DeadThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"持有自己的锁"+lockA);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"持有别人的锁"+lockB);
            }
        }

    }
}
