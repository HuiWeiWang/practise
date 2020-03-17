package com.huiwei.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/3/15 13:53
 **/
public class Test {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        System.out.println(list.size());
        ClassLoader.getSystemClassLoader();
    }
}
