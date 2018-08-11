package GUI.Listener;

import DAO.ConfigDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import GUI.Frame.MainFrame;
import GUI.Frame.StuFrame;
import GUI.Frame.TecFrame;
import Util.GUIUtil;
import entity.Teacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame frame = MainFrame.getInstance();
        JButton button = (JButton)e.getSource();
        if(button == frame.button4)
            frame.dispose();
        else if(button == frame.button3)
        {
            ConfigDAO dao = new ConfigDAO();

            if(!(GUIUtil.checkEmpty(frame.field1,"用户名")&&GUIUtil.checkEmpty(frame.field2,"密码")))
                return;
            String user = frame.field1.getText();
            String pass = frame.field2.getText();
            frame.config.setUser(user);
            frame.config.setPass(pass);
            boolean flag = dao.login(user,pass);
            if(flag)
            {
                if(frame.button2.isSelected())
                {
                    StudentDAO dao1 = new StudentDAO();
                    if(!dao1.isStudent(user))
                    {
                        JOptionPane.showMessageDialog(null,"权限错误，请重新选择","提示",JOptionPane.ERROR_MESSAGE);

                        return;
                    }
                    frame.dispose();
                    StuFrame.getInstance();
                }
                else if(frame.button1.isSelected())
                {
                    TeacherDAO dao1 = new TeacherDAO();
                    if(!dao1.isTeacher(user))
                    {
                        JOptionPane.showMessageDialog(null,"权限错误，请重新选择","提示",JOptionPane.ERROR_MESSAGE);

                        return;
                    }
                    frame.dispose();
                    TecFrame.getInstance();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"账号或密码错误，请重新输入","提示",JOptionPane.ERROR_MESSAGE);
                frame.field1.grabFocus();
            }
        }
    }
}
