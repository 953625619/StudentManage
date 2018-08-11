package service;

import DAO.CourseDAO;
import DAO.SelectDAO;
import entity.Course;
import entity.Grade;

import java.util.List;

public class SelectService  {
    SelectDAO dao = new SelectDAO();
    public void add(String sno,String cno)
    {
        Grade grade = new Grade(sno,cno);
        dao.add(grade);
    }
    public void delete(String sno,String cno)
    {
        Grade grade = new Grade(sno,cno);
        dao.delete(grade);
    }
    public List<Grade> list(String sno)
    {
        return dao.list(sno);
    }
}
