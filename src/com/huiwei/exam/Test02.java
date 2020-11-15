package com.huiwei.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test02 {

    public static void main(String[] args) {
        String s = emptySpace("hello     world     java  ");
        System.out.println(s);
    }


    //题目2：输入"hello     world     java  ",输出"java world hello"

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
    题目 5：统计一个字符串abc1123ab…中每个字符出现的次数
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
     //  select name from( select name,min(fenshu) from student group by name having min(fenshu) > 80) stu
}
