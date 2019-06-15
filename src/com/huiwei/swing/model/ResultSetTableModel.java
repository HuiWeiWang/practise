package com.huiwei.swing.model;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetTableModel extends AbstractTableModel{
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    public ResultSetTableModel(ResultSet rs) {
        this.rs = rs;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //设置表格每列的列名
    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column+1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
    //设置表格的行数
    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //设置表格的列数
    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //当用户编辑单元格时，将触发该方法
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            //结果集定位到对应行数
            rs.absolute(rowIndex+1);
            //修改单元格对应的值
            rs.updateObject(columnIndex+1,aValue);
            //提交修改
            rs.updateRow();
            //触发单元格的修改事件
            fireTableCellUpdated(rowIndex,columnIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //设置单元格可编辑
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    //设置表格单元格的值
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex+1);
            return rs.getObject(columnIndex+1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
