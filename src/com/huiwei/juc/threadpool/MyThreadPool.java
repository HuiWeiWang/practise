package com.huiwei.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyThreadPool
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/4/1 11:05
 **/
public class MyThreadPool {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//һ�ع̶����߳�
        ExecutorService threadPool1 = Executors.newCachedThreadPool();//һ��N�߳�
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//һ��һ�߳�
        //PS:����3�������̳߳صķ�ʽ���������ڹ�����ʹ�ã������·���������
        ExecutorService threadPoolTrue = new ThreadPoolExecutor(
                1,//һ����0��1
                5,//1��cpu�ܼ��ͣ�һ����cpu����+1��2��io�ܼ��ͣ�cpu��/(1-����ϵ��) ����ϵ��һ����0.8~0.9
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //ģ��10���û�������ҵ��ÿ���û�����һ�������ⲿ�������߳�
        try {
            for (int i = 0; i < 20; i++) {
                int count = i;
                threadPoolTrue.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ����ҵ��"+count);
                });
                threadPoolTrue.submit(()->{});
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolTrue.shutdown();//�̳߳�����һ��Ҫ�ر�
        }
    }
}
