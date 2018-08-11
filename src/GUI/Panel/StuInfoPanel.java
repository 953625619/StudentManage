package GUI.Panel;

import DAO.StudentDAO;
import GUI.Frame.MainFrame;
import Util.ColorUtil;
import Util.GUIUtil;
import entity.Student;

import javax.swing.*;
import java.awt.*;

public class StuInfoPanel extends WorkPanel {
    private static final StuInfoPanel panel = new StuInfoPanel();
    public static StuInfoPanel getInstance()
    {
        return panel;
    }
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;

    JPanel jpanel;
    StudentDAO dao = new StudentDAO();
    Student student = dao.getBySno(MainFrame.getInstance().config.getUser());
    public StuInfoPanel()
    {
        label1 = new JLabel("学号：");
        label2 = new JLabel(student.getSno());
        label3 = new JLabel("姓名：");
        label4 = new JLabel(student.getSname());
        label5 = new JLabel("性别：");
        label6 = new JLabel(student.getSsex());
        label7 = new JLabel("年龄：");
        label8 = new JLabel(Integer.toString(student.getSage()));
        label9 = new JLabel("专业：");
        label10 = new JLabel(student.getDepa());
        jpanel = new JPanel(new GridLayout(5,2));
        jpanel.add(label1);
        jpanel.add(label2);
        jpanel.add(label3);
        jpanel.add(label4);
        jpanel.add(label5);
        jpanel.add(label6);
        jpanel.add(label7);
        jpanel.add(label8);
        jpanel.add(label9);
        jpanel.add(label10);
        GUIUtil.setColor(ColorUtil.blueColor,label2,label4,label6,label8,label10);
        label11 = new JLabel("个人信息如下：");
        label12 = new JLabel();
        label12.setIcon(new ImageIcon("E:\\project\\StudentManager\\img\\gareen.jpg"));

        this.setLayout(new BorderLayout());
        this.add(jpanel,BorderLayout.CENTER);
        this.add(label11,BorderLayout.NORTH);
        this.add(label12,BorderLayout.WEST);
    }
}
