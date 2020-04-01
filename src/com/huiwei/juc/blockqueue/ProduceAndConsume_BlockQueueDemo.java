package com.huiwei.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ProduceAndConsume_BlockQueueDemo
 * @Description volatile/CAS/atomic/BlockQueue/�߳̽���
 * @Author WangHuiWei
 * @Date 2020/3/30 20:03
 **/
public class ProduceAndConsume_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t�����߳�����");
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t�����߳�����");
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

        System.out.println("5s�ӵ������ϰ�main�߳̽�ͣ�������");
        resource.stop();
    }
}

class MyResource{
    private volatile boolean FLAG = true;//Ĭ�Ͽ�������������+����
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    //�������ͨ�����췽��������������Ҫ���ӿڲ�����
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());//�����ӡ���ڲ鿴��־
    }

    //����
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){//���߳̽�������while������ifѭ��
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,1, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t �������" + data + "�ɹ�");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t �������" + data + "ʧ��");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t���ϰ��ͣ����ʾflag=false��������������");
    }
    //����
    public void myConsumer() throws Exception{
        String result = null;
        boolean retValue;
        while (FLAG){//���߳̽�������while������ifѭ��
            result = blockingQueue.poll(2,TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()+"\t ���Ѷ���" + result + "�ɹ�");
            if(null == result || "".equals(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t����2s��û��ȡ�����⣬�����˳�");
                System.out.println();
                System.out.println();
                return;
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t���ϰ��ͣ����ʾflag=false��������������");
    }
    public void stop() throws Exception{
        this.FLAG = false;
    }
}
