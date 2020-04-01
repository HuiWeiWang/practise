package com.huiwei.juc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName ConcurrentDemo
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/3/30 15:12
 **/
public class ConcurrentDemo {
    public static void main(String[] args) {
      List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },""+i).start();
        }
        while (Thread.activeCount() > 2){
        }

    }
}
