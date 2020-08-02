package com.huiwei.exam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        String str = "hello     world     java  ";
       // System.out.println(str);
        printClearGap(str);
        //输入一个字符串
        //5、
      /*  String str = "aaabbbccc";
        Map<Character, Integer> map = statisticalCount( str );
        System.out.println( map );*/
    }

    //题目 1. 给定一个String字符串，打印出所有的子串（subString）
    public static void printSubString(String str) {
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }

    //题目2：输入"hello     world     java  ",输出"java world hello"
    public static void printClearGap(String str) {
        str = str.trim();
        String newStr = "";
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                count++;
                continue;
            }
            if(count!=0){
                newStr+=" ";
                count=0;
            }
            newStr+=chars[i];
        }
        System.out.println(newStr);
    }


    //题目 3：Java集合类有哪些，其中List如何排序


    //java集合类主要有2大分支（1）Collection （2）Map
    //其中list接口下有：ArrayList、LinkedList 和 Vector。
    //Set接口下有：HashSet、TreeSet、LinkedHashSet
    //Map接口下有：HashMap、LinkedHashMap、Hashtable 和 TreeMap
    //List排序通过它的元素实现Comparable接口进行排序

    /*题目 4：实现 Java list，要求实现 list 的 get(), add(), remove() 三个功能函数, 不能直接使用 ArrayList、
    LinkedList 等 Java 自带高级类
    public class MyList {

        public Object get(int i) {
        }

        public void add(Object obj) {
        }

        public boolean remove(Object obj) {
        }

    }
*/

    /*
    题目 5：统计一个字符串abc1123ab…中每个字符出现的次数
    */
    public static Map<Character, Integer> statisticalCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
        }
        return map;
    }

/*
题目 6：用一条SQL语句 查询出每门课都大于80分的学生姓名. 表结构与数据如下：
     name   kecheng   fenshu
     张三     语文       81
     张三     数学       75
     李四     语文       76
     李四     数学       90
     王五     语文       81
     王五     数学       100
     王五     英语       90
*/
//select name from (select name,min(fenshu) from student group by name having min(fenshu)>80) stu;

//select name from (select name,min(fenshu) from student group by name having min(fenshu)>80) stu;

}
