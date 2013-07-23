/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class SheetTableModel extends DefaultTableModel {

    private String[] defaultString = {"品号", "材料成本", "人工成本", "制造费用", "委外加工费用"};

    public void setString(String[] sos) {
        this.defaultString = sos.clone();
    }

    public SheetTableModel() {
        super.setDataVector(setRowData(), getColumnName());
        super.setRowCount(0);

    }

    private Vector getColumnName() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(defaultString));
        Vector vc = new Vector(list);
        return vc;
    }

    private String[] getColumnNmameString() {
        return defaultString;
    }

    private Vector setRowData() {
        Vector vc = new Vector();
//        vc.add(false);
        return vc;
    }

}
