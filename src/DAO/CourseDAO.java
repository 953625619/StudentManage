package DAO;

import Util.SQLUtil;
import entity.Course;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public List<Course> list()
    {
        return list(0,Short.MAX_VALUE);
    }
    public List<Course> list(int start,int page)
    {
        List<Course> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select distinct * from course order by cno desc limit ?,?"))
        {
            statement.setInt(1,start);
            statement.setInt(2,page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Course grade = new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有学生","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public Course getByCno(String cno)
    {

        Course course = new Course();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from course where cno = ?"))
        {
            statement.setString(1,cno);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                course = new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
              }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有课程","提示",JOptionPane.ERROR_MESSAGE);
        }
        return course;
    }
}

