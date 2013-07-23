/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POI;

/**
 *
 * @author John
 */
public class ExcelTest {

    public static void main(String[] args) {
        // 打开Excel文件
        Excel e = new Excel("Z:\\开发部图像信息采集核对表.xls");
        // 选择文件中的第一张表并且返回Table视图
        // 查找所有性别为男的行，并返回Table视图
        // 在上次查找结果中查找所有工号以3结束的行，并返回Table视图
        Table t = e.getSheet(0).getAsTable().findRowByCellValue("性别", "男", Table.FIND_EQUALS)
                .findRowByCellValue("工号", "3", Table.FIND_ENDS_WITH);
        // 打印出表的表头信息
        for (String s : t.getHeader()) {
            System.out.print(s + "\t");
        }
        System.out.println();
        for (int i = 0; i < t.getRowSize(); i++) {
            System.out.println(t.getRowAt(i));
        }
    }
}
