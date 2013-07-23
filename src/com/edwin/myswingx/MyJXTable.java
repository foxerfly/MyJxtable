/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.myswingx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author EDWIN
 */
public class MyJXTable extends JXTable {

//    public static final Color ROW_COLOR = UIManager.getColor("nb.dataview.table.background") != null ? UIManager.getColor("nb.dataview.table.background") : Color.WHITE;
//    public static final Color ALTERNATE_ROW_COLOR = UIManager.getColor("nb.dataview.table.altbackground") != null ? UIManager.getColor("nb.dataview.table.altbackground") : new Color(0.92F, 0.95F, 0.99F);
//    public static final Color GRID_COLOR = UIManager.getColor("nb.dataview.table.gridbackground") != null ? UIManager.getColor("nb.dataview.table.gridbackground") : new Color(14277081);
//    public static final Color ROLLOVER_ROW_COLOR = UIManager.getColor("nb.dataview.table.rollOverRowBackground") != null ? UIManager.getColor("nb.dataview.table.rollOverRowBackground") : new Color(0.94F, 0.96F, 0.96F);
    public static final Color ROW_COLOR = Color.WHITE;
    public static final Color ALTERNATE_ROW_COLOR = new Color(0.92F, 0.95F, 0.99F);
    public static final Color GRID_COLOR = new Color(14277081);
    public static final Color ROLLOVER_ROW_COLOR = new Color(0.94F, 0.96F, 0.96F);

    public MyJXTable(TableModel tb) {
        super(tb);
        this.setGridColor(GRID_COLOR);
        this.setRowHeight(rowHeight);
        ((DefaultTableModel) super.getModel()).setRowCount(0);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setDragEnabled(false);
    }

    public MyJXTable() {
        this.setGridColor(GRID_COLOR);
        this.setRowHeight(rowHeight);
//        ((DefaultTableModel) super.getModel()).setRowCount(0);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setDragEnabled(false);
    }

    public TableCellRenderer getCellRenderer(int row, int column) {
        return new MyCellRenderer();
    }

    class MyCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            this.setColor(cell, table, isSelected, hasFocus, row, column);
            return cell;
        }
        /*
         * 设置颜色
         */

        private void setColor(Component component, JTable table, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                component.setBackground(ROLLOVER_ROW_COLOR);
                setBorder(null);//去掉边
            } else {
                component.setBackground((row % 2 == 0) ? ROW_COLOR : ALTERNATE_ROW_COLOR);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintEmptyRows(g);
    }

    /**
     * Paints the backgrounds of the implied empty rows when the table model is
     * insufficient to fill all the visible area available to us. We don't
     * involve cell renderers, because we have no data.
     */
    protected void paintEmptyRows(Graphics g) {
        final int rowCount = getRowCount();
        final Rectangle clip = g.getClipBounds();
        final int height = clip.y + clip.height;
        if (rowCount * rowHeight < height) {
            for (int i = rowCount; i <= height / rowHeight; ++i) {
                g.setColor(backgroundColorForRow(i));
                g.fillRect(clip.x, i * rowHeight, clip.width, rowHeight);
                drawHorizontalLine(g, clip, i);
            }
            drawVerticalLines(g, rowCount, height);
        }
    }

    protected void drawHorizontalLine(Graphics g, final Rectangle clip, int i) {
        g.setColor(this.GRID_COLOR);
        g.drawLine(clip.x, i * rowHeight - 1, clip.x + clip.width, i * rowHeight - 1);
    }

    protected void drawVerticalLines(Graphics g, final int rowCount, final int height) {

        g.setColor(this.GRID_COLOR);
        TableColumnModel colModel = getColumnModel();
        int x = 0;
        for (int i = 0; i < colModel.getColumnCount(); ++i) {
            TableColumn column = colModel.getColumn(i);
            x += column.getWidth();
            g.drawLine(x - 1, rowCount * rowHeight, x - 1, height);
        }
    }

    protected Color backgroundColorForRow(int row) {
        return (row % 2 == 0) ? this.ROW_COLOR : this.ALTERNATE_ROW_COLOR;
    }

}
