package com.huiwei.swing;

import javax.swing.*;

public class SimpleTable {
    JFrame jf = new JFrame("简单表格");
    JTable table;
    //定义二位数组作为表格数据
    Object[][] tableData = {new Object[]{"李清照", 29, "女"},
            new Object[]{"苏格拉底", 56, "男"},
            new Object[]{"李白", 35, "男"},
            new Object[]{"会伟", 18, "男"},
            new Object[]{"小甜甜",25,"女"}};
    //定义一维数字作为列标题
    Object[] columnTitle = {"姓名","年龄","性别"};
    public void init(){
        //以二维数组和一维数组来创建一个JTable对象
        table = new JTable(tableData,columnTitle);
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTable().init();
    }
}
