package com.huiwei.exam;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //printSurplusBlank("hello     world     java  ");
        MyList list = new MyList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        //list.remove("ddd");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    ////��Ŀ 1. ����һ��String�ַ�������ӡ�����е��Ӵ���subString��

    public static void printSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    //��Ŀ2������"hello     world     java  ",���"java world hello"

    public static void printSurplusBlank(String str) {
        char[] chars = str.toCharArray();
        String newStr = "";
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                count++;
                continue;
            }
            if (0 != count) {
                newStr += " ";
                count = 0;
            }
            newStr += chars[i];
        }
        System.out.println(newStr);
    }

    /*��Ŀ 3��ʵ�� Java list��Ҫ��ʵ�� list �� get(), add(), remove() �������ܺ���, ����ֱ��ʹ�� ArrayList��
   LinkedList �� Java �Դ��߼���*/

     /*
    ��Ŀ 5��ͳ��һ���ַ���abc1123ab����ÿ���ַ����ֵĴ���
    */

     public static Map<Character,Integer> statisticalCount(String str){
         Map<Character,Integer> map = new HashMap<>();
         char[] chars = str.toCharArray();
         for (int i = 0; i < chars.length; i++) {
             if(map.containsKey(chars[i])){
                 map.put(chars[i],map.get(chars[i])+1);
             }else{
                 map.put(chars[i],1);
             }
         }
         return map;
     }

}

class MyList<T>{
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    MyList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    public Object get(int i) {
        return elementData[i];
    }

    public void add(T obj) {
        //����
        if(size == elementData.length){
            Object[] newArr = new Object[elementData.length<<1];
            System.arraycopy(elementData,0,newArr,0,elementData.length);
            elementData = newArr;
        }
        elementData[size++] = obj;
    }

    public boolean remove(T obj) {
        for (int i = 0; i < elementData.length ; i++) {
            if(obj.equals(elementData[i])){
                System.arraycopy(elementData,i+1,elementData,i,size-i-1);
                elementData[--size] = null;//clear let GC do its work
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.size;
    }
}