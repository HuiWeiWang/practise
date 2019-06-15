package com.huiwei.swing;

import javax.swing.*;

public class AllLookAndFeel {
    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + "--->" + info);
        }
    }
}
