package com.huiwei.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProduceAndConsumeDemo1
 * @Description
 * 多线程3步曲：1、判断 2、干活 3、通知
 * @Author WangHuiWei
 * @Date 2020/3/29 22:46
 **/
public class ProduceAndConsumeDemo1 {

    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                data.increament();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                data.decreament();
            }
        },"BBB").start();
    }
}

class ShareData{
    int number;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increament() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decreament(){
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}