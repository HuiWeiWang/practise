package com.huiwei.swing;

import javax.swing.*;

public class SwingComponent {
    public static void main(String[] args) {
        JFrame f = new JFrame("测试窗口");
        JButton btn = new JButton("按钮1");
        f.add(btn);
        f.pack();
        f.setVisible(true);
    }

}
