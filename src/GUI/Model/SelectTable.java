package GUI.Model;

import DAO.CourseDAO;
import GUI.Frame.MainFrame;
import entity.Course;
import entity.Grade;
import service.SelectService;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SelectTable extends AbstractTableModel {
    String[] strings = {"课程号","课程名","教师编号"};
    SelectService selectService = new SelectService();
    public List<Grade> list = selectService.list(MainFrame.getInstance().config.getUser());
    CourseDAO dao = new CourseDAO();
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
        String cno = grade.getCno();
        Course course = dao.getByCno(cno);
        switch (columnIndex)
        {
            case 0:return course.getCno();
            case 1:return course.getCname();
            case 2:return course.getTno();
        }
        return null;

    }
}
