package com.huiwei.java8;

import java.util.Arrays;
import java.util.List;

public class TestStaticRefrence {
    public static void main(String[] args) {
        Person[] rosterAsArray = new Person[3];
        rosterAsArray[0] = new Person("aaa",3);
        rosterAsArray[1] = new Person("bbb",1);
        rosterAsArray[2] = new Person("ccc",2);
        Arrays.sort(rosterAsArray,Person::compareByAge);
        System.out.println(Arrays.toString(rosterAsArray));

        List<Integer> list = Arrays.asList(82,22,34,50,9);
        list.sort(Integer::compare);
        System.out.println(list);


    }
}
