package com.huiwei.java8;

import java.util.function.Supplier;

public class TestInstanceReference {
    public static void main(String[] args) {

        TestInstanceReference test = new TestInstanceReference();
        User user = new User("ŷ����", 32);
        Supplier<Integer> supplier = () -> user.getAge();
        System.out.println("Lambda���ʽ��������" + supplier.get());

        Supplier<String> supplier2 = user::getName;
        System.out.println("ʵ������������������" + supplier2.get());
    }
}
