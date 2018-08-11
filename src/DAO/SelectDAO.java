package DAO;

import Util.SQLUtil;
import entity.Grade;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDAO {
    public void add(Grade grade)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO grade VALUES (?,?,?)"))
        {
            statement.setString(1,grade.getSno());
            statement.setString(2,grade.getCno());
            statement.setDouble(3,grade.getGrade());
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"选课成功","提示",JOptionPane.PLAIN_MESSAGE);

        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"选课失败","提示",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void delete(Grade grade)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE from grade where sno = ? and cno = ?"))
        {
            String sno = grade.getSno();
            String cno = grade.getCno();
            statement.setString(1,sno);
            statement.setString(2,cno);
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"退课成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"退课失败","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<Grade> list(String sno)
    {
        return list(0,Short.MAX_VALUE,sno);
    }
    public List<Grade> list(int start, int page , String sno)
    {
        List<Grade> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from grade where sno = ? order by grade desc limit ?,?"))
        {
            statement.setString(1,sno);
            statement.setInt(2,start);
            statement.setInt(3,page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Grade grade = new Grade(resultSet.getString(1),resultSet.getString(2));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"还未选课","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
}
