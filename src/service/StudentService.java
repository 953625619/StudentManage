package service;

import DAO.StudentDAO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentDAO dao = new StudentDAO();
    public List<Student> list()
    {
        return dao.list();
    }
    public void add(String sno,String sname ,String ssex,int sage ,String depa)
    {
        Student student = new Student(sno,sname,ssex,sage,depa);
        dao.add(student);
    }
    public void update(String sno,String sname ,String ssex,int sage ,String depa)
    {
        Student student = new Student(sno,sname,ssex,sage,depa);
        dao.update(student);
    }
    public void delete(String sno)
    {
        Student student = new Student();
        student.setSno(sno);
        dao.delete(student);
    }
    public List<Student> searchBySno(String sno)
    {
        List<Student> list = new ArrayList<>();
        list.add( dao.getBySno(sno));
        return list;
    }
    public List<Student> searchByDepa(String depa)
    {
        return dao.getByDepa(depa);
    }
}
