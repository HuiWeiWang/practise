package com.huiwei.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        Collections.sort(names1,(s1,s2) -> s1.compareTo(s2));
        System.out.println(names1);
    }
}
