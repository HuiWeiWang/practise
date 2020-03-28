package com.huiwei.file;

import java.io.File;

/**
 * @ClassName directory
 * @Description TODO
 * @Author WangHuiWei
 * @Date 2020/3/24 19:00
 **/
public class Directory {
    public static void main(String[] args) {
        File file = new File("D:\\temp\\bb\\cc");
       if(!file.isDirectory()){
           boolean b = file.mkdirs();
           System.out.println(b);
       }
    }
}
