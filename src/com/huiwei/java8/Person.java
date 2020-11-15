package com.huiwei.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Person {
    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static int compareByAge(Person a, Person b) {
        return a.age.compareTo(b.age);
    }
}
