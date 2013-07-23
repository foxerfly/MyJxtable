/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import POI.Excel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWIN
 */
//输入字符串组即可以返回加好列名的modle
public class MyJTableModel {

    private Vector vcColumnNames = null;
    protected Vector vcData = null;
    private String filePath = "";
    private Excel xls;

    public MyJTableModel(String... columnNames) {
//        vcColumnNames.clear();
        setColumnNames(columnNames);
    }

    public MyJTableModel(String filePath) {
        this.filePath = filePath;
        xls = new Excel(filePath);
        setExcelToTableColumnNames();
        setExcelData();
    }

    /**
     *
     * @param columnNames
     */
    public MyJTableModel(String[] columnNames, Map mp) {
//        vcColumnNames.clear();
        setColumnNames(columnNames);

    }

    public Vector setColumnNames(String... columnNames) {
        vcColumnNames = new Vector((Arrays.asList(columnNames)));
        return vcColumnNames;
    }

    //获取EXCEL表格列名数据
    public Vector setExcelToTableColumnNames() {

        vcColumnNames = new Vector(Arrays.asList(xls.getSheet(0).getColumnNames()));
//        System.out.println(vcColumnNames);
        return vcColumnNames;
    }

    public Vector setData() {
        return vcData;
    }

    //获取EXCEL表格中的list数据
    public Vector setExcelData() {
        Collection c = new ArrayList<ArrayList>();
        c = xls.getSheet(0).getAllRow();
        vcData = new Vector(c);
        return vcData;
    }

    public DefaultTableModel buildModel() {
//        setColumnNames(columnNames);
        return new DefaultTableModel(vcData, vcColumnNames);
    }

    public DefaultTableModel buildSpecModel() {
//        setColumnNames(columnNames);
        return new DefaultTableModel(vcData, vcColumnNames);
    }

    //返回构建好数据和列名的tablemodel
    public DefaultTableModel buildExcelToTableModel() {

        DefaultTableModel dd = new DefaultTableModel(xls.getSheet(0).getObjectAllRow(), xls.getSheet(0).getColumnNames());
        return dd;
    }

}
