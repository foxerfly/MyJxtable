/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWIN
 */
//根据查询的SQL语句，自动创建modle
public class MySqlJTableModel extends MyJTableModel {

    private ArrayList<String> al = new ArrayList<String>();

    public MySqlJTableModel(String sql) {
        al = getSqlArray(sql);
    }

    public ArrayList<String> getSqlArray(String sql) {
        ArrayList<String> list = new ArrayList<String>();



        return list;
    }

    public String[] getString() {
        return (String[]) al.toArray();
    }

    public DefaultTableModel buildModel() {
        return new DefaultTableModel(super.vcData, super.setColumnNames(getString()));
    }

}
