package GUI.Panel;


import GUI.Listener.GradeListener;
import GUI.Model.GradeTable;
import Util.ColorUtil;
import Util.GUIUtil;
import service.GradeService;

import javax.swing.*;
import java.awt.*;

public class GradePanel extends WorkPanel {
    {
        GUIUtil.useLNF();
    }
    private static final GradePanel grade = new GradePanel();

    public static GradePanel getInstance(){
        return grade;
    }

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    GradeTable table ;
    public JTable jTable;
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    public JButton button1;
    public JButton button2;
    public JButton button3;
    JScrollPane scrollPane = new JScrollPane();
    GradeService service = new GradeService();
    public GradePanel()
    {
        GradeService service = new GradeService();
        label1 = new JLabel("平均分");
        label2 = new JLabel(String.format("%.2f",service.findAvg()));
        label3 = new JLabel("最高分");
        label4 = new JLabel(Double.toString(service.findMax()));
        label5 = new JLabel("最低分");
        label6 = new JLabel(Double.toString(service.findMin()));
        GUIUtil.setColor(ColorUtil.blueColor,label2,label4,label6);
        table = new GradeTable();
        jTable = new JTable(table);
        panel.setLayout(new GridLayout(6,1));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        button1 = new JButton("添加");
        button2 = new JButton("修改");
        button3 = new JButton("删除");
        button1.addActionListener(new GradeListener());
        button2.addActionListener(new GradeListener());
        button3.addActionListener(new GradeListener());
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        scrollPane.setViewportView(jTable);
        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.WEST);
        this.add(scrollPane,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.SOUTH);
    }
    public void updateDate()
    {
        GradeService service = new GradeService();
        label2.setText(String.format("%.2f",service.findAvg()));
        label4.setText(Double.toString(service.findMax()));
        label6.setText(Double.toString(service.findMin()));
        table.list = service.list();

        jTable.updateUI();

        jTable.getSelectionModel().setSelectionInterval(0, 0);

        if(0==table.list.size()){
            button2.setEnabled(false);
            button3.setEnabled(false);
            button1.setEnabled(false);
        }
        else{
            button3.setEnabled(true);
            button2.setEnabled(true);
            button1.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(GradePanel.getInstance());
    }
}
