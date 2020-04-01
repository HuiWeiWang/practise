package com.huiwei.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ProduceAndConsume_BlockQueueDemo
 * @Description volatile/CAS/atomic/BlockQueue/线程交互
 * @Author WangHuiWei
 * @Date 2020/3/30 20:03
 **/
public class ProduceAndConsume_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            try {
                resource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5s钟到，大老板main线程叫停，活动结束");
        resource.stop();
    }
}

class MyResource{
    private volatile boolean FLAG = true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    //这里队列通过构造方法传进来，而且要传接口不传类
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());//这里打印用于查看日志
    }

    //生产
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){//多线程交互都用while而不用if循环
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,1, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停，表示flag=false，生产动作结束");
    }
    //消费
    public void myConsumer() throws Exception{
        String result = null;
        boolean retValue;
        while (FLAG){//多线程交互都用while而不用if循环
            result = blockingQueue.poll(2,TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()+"\t 消费队列" + result + "成功");
            if(null == result || "".equals(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t超过2s钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停，表示flag=false，生产动作结束");
    }
    public void stop() throws Exception{
        this.FLAG = false;
    }
}
