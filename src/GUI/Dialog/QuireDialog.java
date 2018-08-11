package GUI.Dialog;

import GUI.Panel.InfoPanel;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuireDialog extends JDialog {
    class QuireListener implements ActionListener{
        InfoPanel infoPanel = InfoPanel.getInstance();
        StudentService studentService = new StudentService();
        @Override
        public void actionPerformed(ActionEvent e) {
             String target =(String) comboBox2.getSelectedItem();
            if (target.equals("学号查询"))
            {
                String sno = field.getText();
                infoPanel.infoTable.list = studentService.searchBySno(sno);
                dispose();
                infoPanel.jTable.updateUI();
                infoPanel.jTable.getSelectionModel().setSelectionInterval(0, 0);
            }
            else if(target.equals("专业查询"))
            {
                String depa =  field.getText();
                infoPanel.infoTable.list = studentService.searchByDepa(depa);
                dispose();
                infoPanel.jTable.updateUI();
                infoPanel.jTable.getSelectionModel().setSelectionInterval(0, 0);
            }
        }
    }
    String[] strings = new String[]{"学号查询","专业查询"};
    JComboBox comboBox2 ;
    public JTextField field;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    public JButton button ;
    public QuireDialog()
    {

        comboBox2 = new JComboBox(strings);
        field = new JTextField(5);
        button = new JButton("查询");
        panel1= new JPanel();
        panel3= new JPanel();
        panel2 = new JPanel(new GridLayout(2,1));
        panel1.add(comboBox2);
        panel1.add(field);
        panel2.add(panel1);
        panel3.add(button);
        panel2.add(panel3);
        button.addActionListener(new QuireListener());
        this.setContentPane(panel2);
        this.setBounds(300,300,200,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
