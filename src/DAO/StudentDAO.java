package DAO;

import Util.SQLUtil;
import entity.Student;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void add(Student student)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO stu VALUES (?,?,?,?,?)"))
        {
            String no = student.getSno();
            String name = student.getSname() ;
            String sex = student.getSsex() ;
            int age = student.getSage();
            String depa = student.getDepa();
            statement.setString(1,no);
            statement.setString(2,name);
            statement.setString(3,sex);
            statement.setInt(4,age);
            statement.setString(5,depa);
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"添加失败","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void update(Student student)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE  stu SET  sname = ?, ssex = ? ,sage = ?,depa = ? WHERE sno = ?"))
        {
            String no = student.getSno();
            String name = student.getSname() ;
            String sex = student.getSsex() ;
            int age = student.getSage();
            String depa = student.getDepa();
            statement.setString(5,no);
            statement.setString(1,name);
            statement.setString(2,sex);
            statement.setInt(3,age);
            statement.setString(4,depa);
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void delete(Student student)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE from stu where sno = ?"))
        {
            String no = student.getSno();
            statement.setString(1,no);
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<Student> list()
    {
        return   list(0,Short.MAX_VALUE);
    }
    public List<Student> list(int start,int page)
    {
        List<Student> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from stu order by sno desc limit ?,?"))
        {
            statement.setInt(1,start);
            statement.setInt(2,page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Student student = new Student(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有学生","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public boolean isStudent(String sno)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from stu where sno = ?"))
        {
            statement.setString(1,sno);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
             }
        return false;
    }
    public Student getBySno(String sno)
    {
        Student student = new Student();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from stu where sno = ?"))
        {
            statement.setString(1,sno);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                 student = new Student(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有此学生","提示",JOptionPane.ERROR_MESSAGE);
        }
        return student;
    }
    public List<Student> getByDepa(String depa)
    {
        List<Student> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from stu where depa = ?"))
        {
            statement.setString(1,depa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
               Student student = new Student(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
            list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有学生","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        System.out.println(dao.list().size());
        for (Student student:
            dao.list() ) {
            System.out.println(student);
        }
    }
}
