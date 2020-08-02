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
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池固定数线程
        ExecutorService threadPool1 = Executors.newCachedThreadPool();//一池N线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//一池一线程
        //PS:以上3个创建线程池的方式都不建议在工作中使用，用以下方法来创建
        ExecutorService threadPoolTrue = new ThreadPoolExecutor(
                1,//一般配0或1
                5,//1、cpu密集型：一般配cpu数量+1；2、io密集型：cpu数/(1-阻塞系数) 阻塞系数一般在0.8~0.9
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 20; i++) {
                int count = i;
                threadPoolTrue.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+count);
                });
                threadPoolTrue.submit(()->{});
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolTrue.shutdown();//线程池用完一定要关闭
        }
    }
}
