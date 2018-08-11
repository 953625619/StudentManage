package DAO;

import Util.SQLUtil;
import entity.Teacher;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    public List<Teacher> list()
    {
        return list(0,Short.MAX_VALUE);
    }
    public List<Teacher> list(int start,int page)
    {
        List<Teacher> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from tec order by tno desc limit ?,?"))
        {
            statement.setInt(1,start);
            statement.setInt(2,page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Teacher teacher = new Teacher(resultSet.getString(1),resultSet.getString(2));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有老师","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public Boolean isTeacher(String tno)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from tec where tno = ?"))
        {
            statement.setString(1,tno);
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
}
