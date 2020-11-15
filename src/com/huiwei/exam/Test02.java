package com.huiwei.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test02 {

    public static void main(String[] args) {
        String s = emptySpace("hello     world     java  ");
        System.out.println(s);
    }


    //��Ŀ2������"hello     world     java  ",���"java world hello"

    public static String emptySpace(String str){
        Stack<String> stack = new Stack<>();
        String newStr = "";
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length ; i++) {
            if(' '==chars[i]){
                count++;
                continue;
            }
            if(count != 0){
                stack.push(newStr);
                count = 0;
                newStr = "";
            }
            newStr += chars[i];
        }
        if(newStr != ""){
            stack.push(newStr);
        }
        newStr = "";
        while (true){
            if(stack.empty()){
                break;
            }
            newStr+=stack.pop();
            newStr+=" ";
        }
        return newStr.trim();
    }

     /*
    ��Ŀ 5��ͳ��һ���ַ���abc1123ab����ÿ���ַ����ֵĴ���
    */

     public static Map<Character,Integer> count(String str){
         Map<Character,Integer> map = new HashMap<>();
         char[] chars = str.toCharArray();
         for (int i = 0; i < chars.length; i++) {
             if(map.containsKey(chars[i])){
                 map.put(chars[i],map.get(chars[i]+1));
             }else{
                 map.put(chars[i],1);
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
     //  select name from( select name,min(fenshu) from student group by name having min(fenshu) > 80) stu
}
