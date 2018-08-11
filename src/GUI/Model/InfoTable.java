package GUI.Model;

import DAO.StudentDAO;
import entity.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InfoTable extends AbstractTableModel {
    String[] info = new String[]{"学号","姓名","性别","年龄","专业"};
    StudentDAO studentDAO = new StudentDAO();
    public List<Student> list = studentDAO.list();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return info.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return info[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = list.get(rowIndex);
        switch (columnIndex)
        {
            case 0:return student.getSno();
            case 1:return student.getSname();
            case 2:return student.getSsex();
            case 3:return student.getSage();
            case 4:return student.getDepa();

        }
        return null;
    }

}
