package com.huiwei.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName JvmParameterDemo
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/4/1 19:21
 **/
public class JvmParameterDemo {
    public static void main(String[] args) {
        System.out.println("***********JvmParameterDemo");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
