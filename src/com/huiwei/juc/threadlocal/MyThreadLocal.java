package com.huiwei.juc.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {

    private Map<Thread,T> map = Collections.synchronizedMap(new HashMap<>());

    public void set(T t){
        map.put(Thread.currentThread(),t);
    }

    public T get(){
        return map.get(Thread.currentThread());
    }
    public void remove(){
        map.remove(Thread.currentThread());
    }
}
