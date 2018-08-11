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

public class GradeDAO {
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
                JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE);

        }
             catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"不存在此学生或课程","提示",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void update(Grade grade)
    {
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE grade SET grade = ? WHERE sno = ?"))
        {
            statement.setDouble(1,grade.getGrade());
            statement.setString(2,grade.getSno());
            int result = statement.executeUpdate();
            if(result>0)
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.ERROR_MESSAGE);

        }
    }
    public void delete (Grade grade)
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
                JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<Grade> list()
    {
        return   list(0,Short.MAX_VALUE);
    }
    public List<Grade> list(int start,int page)
    {
        List<Grade> list = new ArrayList<>();
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from grade order by grade desc limit ?,?"))
        {
            statement.setInt(1,start);
            statement.setInt(2,page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Grade grade = new Grade(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"没有学生","提示",JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public double findMax()
    {
        double max = 0;
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT max(grade) from grade "))
        {
            ResultSet result = statement.executeQuery();
            if(result.next())
                max = result.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"查找失败","提示",JOptionPane.ERROR_MESSAGE);
        }
        return max;
    }

    public double findMin()
    {
        double min = 0;
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT min(grade) from grade "))
        {
            ResultSet result = statement.executeQuery();
            if(result.next())
                min = result.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"查找失败","提示",JOptionPane.ERROR_MESSAGE);
        }
        return min;
    }

    public double findAvg()
    {
        double avg = 0;
        try(Connection connection = SQLUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT avg(grade) from grade "))
        {
            ResultSet result = statement.executeQuery();
            if(result.next())
                avg = result.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"查找失败","提示",JOptionPane.ERROR_MESSAGE);
        }
        return avg;
    }
}
