package com.huiwei.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {

        //生成流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //forEach
        collect.forEach(System.out::println);
        Random random = new Random();
        IntStream ints = random.ints();
        ints.limit(10).forEach(System.out::println);
        System.out.println("====================");
        //map
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect1 = numbers.stream().map(element -> element * 3).distinct().collect(Collectors.toList());
        collect1.forEach(System.out::println);
        System.out.println("====================");
        //filter
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings1.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
        System.out.println("====================");
        //limit
        Random random1 = new Random();
        random1.ints().limit(10).forEach(System.out::println);
        System.out.println("====================");
        //Collectors
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String mergedString = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        System.out.println("====================");


        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> (x)).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }
}
