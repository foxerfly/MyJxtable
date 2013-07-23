/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author John
 */
public abstract class TableCellColor {

    private static final Color ROW_COLOR = Color.WHITE;
    private static final Color ALTERNATE_ROW_COLOR = new Color(0.92F, 0.95F, 0.99F);

    public static void makeFace(JTable table) {

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setBackground(row % 2 == 0 ? ROW_COLOR : ALTERNATE_ROW_COLOR);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
        };

        table.setDefaultRenderer(Object.class, tcr);
    }

    public static DefaultTableCellRenderer getDefaultTableCellRenderer() {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setBackground(row % 2 == 0 ? ROW_COLOR : ALTERNATE_ROW_COLOR);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return tcr;
    }

}
