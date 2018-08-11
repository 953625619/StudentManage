package service;

import DAO.GradeDAO;
import entity.Grade;

import java.util.List;

public class GradeService {
    GradeDAO dao = new GradeDAO();
    public List<Grade> list()
    {
        return dao.list();
    }
    public void add(String sno,String cno,double grade)
    {
        Grade grade1 = new Grade(sno,cno,grade);
        dao.add(grade1);
    }
    public void delete(String sno,String cno)
    {
        Grade grade = new Grade();
        grade.setSno(sno);
        grade.setCno(cno);
        dao.delete(grade);
    }
    public void update(double grade,String sno)
    {
        Grade grade1 = new Grade();
        grade1.setSno(sno);
        grade1.setGrade(grade);
        dao.update(grade1);
    }
    public double findMax()
    {
        return dao.findMax();
    }

    public double findMin()
    {
        return dao.findMin();
    }

    public double findAvg()
    {
        return dao.findAvg();
    }

}
