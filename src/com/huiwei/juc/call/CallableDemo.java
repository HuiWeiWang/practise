package com.huiwei.juc.call;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CallableDemo
 * @Description
 * PS:(1)FutureTask计算的值需要较长时间时，把这个任务放在最后
 * （2）多个线程调用同一个FutureTask，只会计算一次
 * @Author WangHuiWei
 * @Date 2020/3/30 21:39
 **/
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        int result1 = 100;
        int result2 = futureTask.get();//这个是导致线程阻塞，放在最后
        System.out.println("********main线程");
        System.out.println("*******result："+futureTask.get());
    }
}


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("***********Callable come in!");
        TimeUnit.SECONDS.sleep(3);
        return 1024;
    }
}
