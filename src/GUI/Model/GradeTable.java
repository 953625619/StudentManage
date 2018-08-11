package GUI.Model;

import entity.Grade;
import service.GradeService;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class GradeTable extends AbstractTableModel {
    String[] strings = {"学号","课程号","成绩"};
    GradeService service = new GradeService();
    public List<Grade> list = service.list();
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return strings.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return strings[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grade grade = list.get(rowIndex);
        switch (columnIndex)
        {
            case 0:return grade.getSno();
            case 1:return grade.getCno();
            case 2:return grade.getGrade();
        }
        return null;
    }
}
