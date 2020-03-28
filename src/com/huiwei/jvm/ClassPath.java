package com.huiwei.jvm;

/**
 * @ClassName ClassPath
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/3/20 21:53
 **/
public class ClassPath {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
