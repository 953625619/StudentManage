package GUI.Dialog;

import GUI.Panel.GradePanel;
import Util.GUIUtil;
import service.GradeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeDialog extends JFrame{

    {
        GUIUtil.useLNF();
    }
    class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            GradeService service = new GradeService();
            if (button == button1)
            {
                if(! (GUIUtil.checkEmpty(field1,"学号")&&GUIUtil.checkEmpty(field2,"课程号")
                        &&GUIUtil.checkEmpty(field3,"成绩")))
                    return;
                String sno = field1.getText();
                String cno =field2.getText();
                double grade = Double.parseDouble(field3.getText());
                service.add(sno,cno,grade);
                GradePanel gradePanel = GradePanel.getInstance();
                frame.dispose();
                gradePanel.updateDate();
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
    public JTextField field1;
    public JTextField field2;
    public JTextField field3;
    JPanel panel;
    JPanel panel1;
    public JButton button1;
    public JButton button2;
    public GradeDialog()
    {
        label1 = new JLabel("学号  ：");
        label2 = new JLabel("课程号：");
        label3 = new JLabel("成绩  ：");
        field1 = new JTextField(5);
        field2 = new JTextField(5);
        field3 = new JTextField(5);
        button1 = new JButton("确定");
        button2 = new JButton("取消");
        button1.addActionListener(new AddListener());
        button2.addActionListener(new AddListener());
        panel = new JPanel(new GridLayout(3,2));
        panel1 = new JPanel();
        panel.add(label1);panel.add(field1);
        panel.add(label2);panel.add(field2);
        panel.add(label3);panel.add(field3);
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
        new GradeDialog();

    }

}
