package com.huiwei.java8;

import java.util.function.Supplier;

public class TestInstanceReference {
    public static void main(String[] args) {

        TestInstanceReference test = new TestInstanceReference();
        User user = new User("欧阳峰", 32);
        Supplier<Integer> supplier = () -> user.getAge();
        System.out.println("Lambda表达式输出结果：" + supplier.get());

        Supplier<String> supplier2 = user::getName;
        System.out.println("实例方法引用输出结果：" + supplier2.get());
    }
}
