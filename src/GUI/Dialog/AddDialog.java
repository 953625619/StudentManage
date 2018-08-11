package GUI.Dialog;

import GUI.Panel.InfoPanel;
import Util.GUIUtil;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JFrame {
   class AddListener implements ActionListener{

       @Override
       public void actionPerformed(ActionEvent e) {
           JButton button = (JButton)e.getSource();
           StudentService studentService = new StudentService();
           if (button == button1)
           {
               if(! (GUIUtil.checkEmpty(field1,"学号")&&GUIUtil.checkEmpty(field2,"姓名")&&GUIUtil.checkEmpty(field3,"性别")
                       &&GUIUtil.checkEmpty(field4,"年龄")&&GUIUtil.checkEmpty(field5,"专业")
                        &&GUIUtil.checkZero(field4,"年龄")))
                   return;
               String sno = field1.getText();
               String sname = field2.getText();
               String ssex =field3.getText();
               int sage = Integer.parseInt(field4.getText());
               String depa = field5.getText();
               studentService.add(sno,sname,ssex,sage,depa);
               InfoPanel infoPanel = InfoPanel.getInstance();
               dialog.dispose();
               infoPanel.updateData();
           }
           else if (button == button2)
           {
               dialog.dispose();
           }
       }
   }

    JFrame dialog;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    public JTextField field1;
    public JTextField field2;
    public JTextField field3;
    public JTextField field4;
    public JTextField field5;
    JPanel panel;
    JPanel panel1;
    public JButton button1;
    public JButton button2;
    public AddDialog()
    {
        label1 = new JLabel("学号：");
        label2 = new JLabel("姓名：");
        label3 = new JLabel("性别：");
        label4 = new JLabel("年龄：");
        label5 = new JLabel("专业：");
        field1 = new JTextField(5);
        field2 = new JTextField(5);
        field3 = new JTextField(5);
        field4 = new JTextField(5);
        field5 = new JTextField(5);
        button1 = new JButton("确定");
        button2 = new JButton("取消");
        button1.addActionListener(new AddListener());
        button2.addActionListener(new AddListener());
        panel = new JPanel(new GridLayout(5,2));
        panel1 = new JPanel();
        panel.add(label1);panel.add(field1);
        panel.add(label2);panel.add(field2);
        panel.add(label3);panel.add(field3);
        panel.add(label4);panel.add(field4);
        panel.add(label5);panel.add(field5);
        panel1.add(button1);
        panel1.add(button2);
        dialog = new JFrame("添加");
        dialog.setLayout(new BorderLayout());
        dialog.add(panel,BorderLayout.CENTER);
        dialog.add(panel1,BorderLayout.SOUTH);
        dialog.setBounds(300,300,400,300);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
new AddDialog();
    }

}
