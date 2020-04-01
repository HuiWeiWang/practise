package com.huiwei.juc.myvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileDemo
 * @Description //volatile�ܹ�ʵ�ֿɼ��ԣ�������֤ԭ����
 * @Author WangHuiWei
 * @Date 2020/3/28 16:13
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        seeOkByVolatile();
       // notAtomicWithVolatile();
       // atomicAdd();
    }
    //��֤volatile���ܱ�֤ԭ����
    private static void notAtomicWithVolatile() {
        MyData data = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    data.addPlusPlus();
                }
            },"�߳�"+i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();//�˴������������߳�ִ���꣬�ټ���ִ�����߳�ʣ���߼�
        }
        System.out.println("��������numberΪ"+data.number);
    }
    //����ԭ��������
    private static void atomicAdd() {
        MyData data = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    data.addAtomic();
                }
            },"�߳�"+i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();//�˴������������߳�ִ���꣬�ټ���ִ�����߳�ʣ���߼�
        }
        System.out.println("��������numberΪ"+data.atomicInteger);
    }

    //��֤volatile�Ŀɼ���
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
        //���numberֵΪ���һֱ�ȴ�
        while (data.number == 0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over��get number value:"+data.number);
    }
    //��֤volatile�Ĳ��ܱ�֤ԭ����

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