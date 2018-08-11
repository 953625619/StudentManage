package GUI.Panel;

import DAO.CourseDAO;
import GUI.Frame.MainFrame;
import GUI.Listener.SelectListener;
import GUI.Model.CourseTable;
import GUI.Model.SelectTable;
import Util.GUIUtil;
import service.SelectService;

import javax.swing.*;
import java.awt.*;

public class StuCoursePanel extends WorkPanel {
    private static final StuCoursePanel course = new StuCoursePanel();
    public static StuCoursePanel getInstance()
    {
        return course;
    }
    CourseTable courseTable ;
    SelectTable selectTable;
    public JTable table1;
    public JTable table2;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JScrollPane scrollPane1 ;
    JScrollPane scrollPane2 ;
    public JButton button1;
    public JButton button2;
    private StuCoursePanel()
    {
        JLabel label1 = new JLabel("已选课程如下：");
        selectTable = new SelectTable();
        table1 = new JTable(selectTable);
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(table1);
        button1 = new JButton("退课");
        panel3 = new JPanel();
        panel3.add(button1);
        panel1 = new JPanel(new BorderLayout());
        panel1.add(label1,BorderLayout.NORTH);
        panel1.add(scrollPane1,BorderLayout.CENTER);
        panel1.add(panel3,BorderLayout.SOUTH);
        JLabel label2 = new JLabel("可选课程如下：");
        courseTable = new CourseTable();
        table2 = new JTable(courseTable);
        scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(table2);
        button2 = new JButton("选课");
        panel4 = new JPanel();
        panel4.add(button2);
        panel2 = new JPanel(new BorderLayout());
        panel2.add(label2,BorderLayout.NORTH);
        panel2.add(scrollPane2,BorderLayout.CENTER);
        panel2.add(panel4,BorderLayout.SOUTH);


        this.setLayout(new GridLayout(2,1));
        this.add(panel1);
        this.add(panel2);

        addListener();

    }

    public void update()
    {
        SelectService selectService = new SelectService();
        selectTable.list = selectService.list(MainFrame.getInstance().config.getUser());
        table1.updateUI();
        table1.getSelectionModel().setSelectionInterval(0, 0);

        if(courseTable.list.size()==0)
        {
            button2.setEnabled(false);
        }
        else
            button2.setEnabled(true);

        if(0==selectTable.list.size()){
            button1.setEnabled(false);

        }
        else{
            button1.setEnabled(true);
        }

    }

    public void addListener()
    {
        button1.addActionListener(new SelectListener());
        button2.addActionListener(new SelectListener());
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(StuCoursePanel.getInstance());
    }
}
