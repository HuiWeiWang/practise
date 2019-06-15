package com.huiwei.swing;

import com.huiwei.swing.model.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableModelTest {
    JFrame jf = new JFrame("数据表管理工具");
    //用于盛放表格的容器
    private JScrollPane scrollPane;
    //用于装载表格的数据
    private ResultSetTableModel model;
    //用于装载数据表的JComboBox
    private JComboBox<String> tableNames = new JComboBox<>();
    private JTextArea changeMsg = new JTextArea(4, 80);
    private ResultSet rs;
    private Connection conn;
    private Statement statement;

    public void init() {
        tableNames.addActionListener(event -> {
            try {
                //如果装载表格的JScrollPane不为空
                if (scrollPane != null) {
                    //从主窗口删除表格
                    jf.remove(scrollPane);
                }
                //从JComboBox中取出用户试图管理的数据表的表名
                String tableName = (String) tableNames.getSelectedItem();
                if(tableName.contains("$")){
                    return;
                }
                //如果结果集不为空，则关闭结果集
                if (rs != null) {
                    rs.close();
                }
                String sql = "select * from " + tableName;
                //查询用户选择的数据表
                rs = statement.executeQuery(sql);
                //使用查询到的ResultSet创建TableModel对象
                model = new ResultSetTableModel(rs);
                //为TableModel添加监听器，监听用户的修改
                model.addTableModelListener(evt -> {
                    int row = evt.getFirstRow();
                    int column = evt.getColumn();
                    changeMsg.append("修改的列：" + column + ",修改的行：" + row + "修改后的值：" + model.getValueAt(row, column));
                });
                //使用TableModel创建JTable，并将对应表格添加到窗口
                JTable table = new JTable(model);
                scrollPane = new JScrollPane(table);
                jf.add(scrollPane, BorderLayout.CENTER);
                jf.validate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        JPanel p = new JPanel();
        p.add(tableNames);
        jf.add(p, BorderLayout.NORTH);
        jf.add(new JScrollPane(changeMsg), BorderLayout.CENTER);
        try {
            //获取数据库连接
            conn = getConnection();
            //获取数据库的MetaData对象
            DatabaseMetaData metaData = conn.getMetaData();
            //创建Statement
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //查询当前数据库的全部数据
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            //将全部数据表添加到JComboBox中
            while (tables.next()) {
                tableNames.addItem(tables.getString(3));
            }
            tables.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (conn != null) {
                        conn.close();
                        ;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //通过加载conn.ini文件来获取数据库连接的详细信息
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("src/conn.properties");
        prop.load(in);
        in.close();
        String driver = prop.getProperty("jdbc.driver");
        String url = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");
        //加载数据库驱动
        Class.forName(driver);
        //获取数据库连接
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        new TableModelTest().init();
       // System.out.println(new File("practise/src/conn.properties").exists());

    }
}
