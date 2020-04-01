package com.huiwei.juc.myvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileDemo
 * @Description //volatile能够实现可见性，但不保证原子性
 * @Author WangHuiWei
 * @Date 2020/3/28 16:13
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        seeOkByVolatile();
       // notAtomicWithVolatile();
       // atomicAdd();
    }
    //验证volatile不能保证原子性
    private static void notAtomicWithVolatile() {
        MyData data = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    data.addPlusPlus();
                }
            },"线程"+i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();//此处用于让其他线程执行完，再继续执行主线程剩余逻辑
        }
        System.out.println("最后算出的number为"+data.number);
    }
    //处理原子性问题
    private static void atomicAdd() {
        MyData data = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    data.addAtomic();
                }
            },"线程"+i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();//此处用于让其他线程执行完，再继续执行主线程剩余逻辑
        }
        System.out.println("最后算出的number为"+data.atomicInteger);
    }

    //验证volatile的可见性
    private static void seeOkByVolatile() {
        MyData data = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" come in");
            try {
                Thread.sleep(1000);
                data.addTo60();
                System.out.println(Thread.currentThread().getName()+" update number value:"+data.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aaa").start();
        //如果number值为零就一直等待
        while (data.number == 0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over，get number value:"+data.number);
    }
    //验证volatile的不能保证原子性

}

class MyData{
    int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addTo60(){
        this.number = 60;
    }

    public void addPlusPlus(){
        this.number++;
    }
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}