package com.huiwei.exam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Test01 {
    public static void main(String[] args) {
        //printClearGap("hello     world     java  ");
        Stack<String>  stack = new Stack<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        String peek = stack.peek();
        System.out.println(peek);
    }

    //��Ŀ 1. ����һ��String�ַ�������ӡ�����е��Ӵ���subString��
    public static void printSubString(String str) {
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }

    //��Ŀ2������"hello     world     java  ",���"java world hello"
    public static void printClearGap(String str) {
        if (str == null || str == "") {
            System.out.println("��������ַ���Ϊ�գ�����������");
        }
        char[] chars = str.toCharArray();

        StringBuilder result = new StringBuilder();
        String singleStr = "";
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (singleStr != "") {
                    stack.push(singleStr);
                    singleStr = "";
                }
                continue;
            }
            singleStr += chars[i];
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        System.out.println(result.toString().trim());
    }


    //��Ŀ 3��Java����������Щ������List�������


    //java��������Ҫ��2���֧��1��Collection ��2��Map
    //����list�ӿ����У�ArrayList��LinkedList �� Vector��
    //Set�ӿ����У�HashSet��TreeSet��LinkedHashSet
    //Map�ӿ����У�HashMap��LinkedHashMap��Hashtable �� TreeMap
    //List����ͨ������Ԫ��ʵ��Comparable�ӿڽ�������

    /*��Ŀ 4��ʵ�� Java list��Ҫ��ʵ�� list �� get(), add(), remove() �������ܺ���, ����ֱ��ʹ�� ArrayList��
    LinkedList �� Java �Դ��߼���
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
    ��Ŀ 5��ͳ��һ���ַ���abc1123ab����ÿ���ַ����ֵĴ���
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
��Ŀ 6����һ��SQL��� ��ѯ��ÿ�ſζ�����80�ֵ�ѧ������. ��ṹ���������£�
     name   kecheng   fenshu
     ����     ����       81
     ����     ��ѧ       75
     ����     ����       76
     ����     ��ѧ       90
     ����     ����       81
     ����     ��ѧ       100
     ����     Ӣ��       90
*/
//select name from (select name,min(fenshu) from student group by name having min(fenshu)>80) stu;

//select name from (select name,min(fenshu) from student group by name having min(fenshu)>80) stu;

}
