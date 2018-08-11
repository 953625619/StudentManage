package GUI.Dialog;

import GUI.Panel.InfoPanel;
import Util.GUIUtil;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDialog extends JFrame {
    {
        GUIUtil.useLNF();
    }
    class EditListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            StudentService studentService = new StudentService();
            if (button == button1)
            {
                if(! (GUIUtil.checkEmpty(field2,"姓名")&&GUIUtil.checkEmpty(field3,"性别")
                        &&GUIUtil.checkEmpty(field4,"年龄")&&GUIUtil.checkEmpty(field5,"专业")
                        &&GUIUtil.checkZero(field4,"年龄")))
                    return;
                String sno = label6.getText();
                String sname =field2.getText();
                String ssex = field3.getText();
                int sage = Integer.parseInt(field4.getText());
                String depa = field5.getText();
                studentService.update(sno,sname,ssex,sage,depa);
                InfoPanel infoPanel = InfoPanel.getInstance();
                frame.dispose();
                infoPanel.updateData();
            }
            else if (button == button2)
            {
               frame.dispose();
            }
        }
    }

    JFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    public JLabel label6;
    public JTextField field2;
    public JTextField field3;
    public JTextField field4;
    public JTextField field5;
    JPanel panel;
    JPanel panel1;
    public JButton button1;
    public JButton button2;
    InfoPanel infoPanel = InfoPanel.getInstance();
    JTable table = infoPanel.jTable;
    public EditDialog()
    {
        InfoPanel infoPanel = InfoPanel.getInstance();
        JTable table = infoPanel.jTable;
        Object obj =  table.getValueAt(table.getSelectedRow(),0);
        label1 = new JLabel("修改的学号为：");
        label6 = new JLabel((String) obj);
        label2 = new JLabel("姓名：");
        label3 = new JLabel("性别：");
        label4 = new JLabel("年龄：");
        label5 = new JLabel("专业：");
        field2 = new JTextField(5);
        field3 = new JTextField(5);
        field4 = new JTextField(5);
        field5 = new JTextField(5);
        button1 = new JButton("确定");
        button2 = new JButton("取消");
        button1.addActionListener(new EditListener());
        button2.addActionListener(new EditListener());
        panel = new JPanel(new GridLayout(5,2));
        panel1 = new JPanel();
        panel.add(label1);panel.add(label6);
        panel.add(label2);panel.add(field2);
        panel.add(label3);panel.add(field3);
        panel.add(label4);panel.add(field4);
        panel.add(label5);panel.add(field5);
        panel1.add(button1);
        panel1.add(button2);
        frame = new JFrame("编辑");
          frame.setLayout(new BorderLayout());
          frame.add(panel,BorderLayout.CENTER);
          frame.add(panel1,BorderLayout.SOUTH);
          frame.setBounds(300,300,400,300);
          frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
          frame.setVisible(true);
    }

    public static void main(String[] args) {

    }

}
