package GUI.Model;

import DAO.CourseDAO;
import entity.Course;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CourseTable extends AbstractTableModel {
    String[] strings = {"课程号","课程名","教师编号"};
    CourseDAO dao = new CourseDAO();
    public List<Course> list = dao.list();
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
        Course course = list.get(rowIndex);
        switch (columnIndex)
        {
            case 0:return course.getCno();
            case 1:return course.getCname();
            case 2:return course.getTno();
        }
        return null;
    }
}
