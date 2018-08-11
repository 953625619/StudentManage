package GUI.Panel;

import GUI.Listener.InfoListener;
import GUI.Model.InfoTable;
import Util.GUIUtil;
import service.StudentService;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends WorkPanel {
    {
        GUIUtil.useLNF();
    }

    private static final InfoPanel info = new InfoPanel();

    public static InfoPanel getInstance(){
        return info;
    }


    public JButton button3 ;
    public JButton button4 ;
    public JButton button5 ;
    public JButton button1 ;
    JPanel panel2;
    public InfoTable infoTable  = new InfoTable();
    public JTable jTable = new JTable(infoTable);
    JScrollPane scrollPane = new JScrollPane();
    private InfoPanel()
    {
        scrollPane.setViewportView(jTable);
        button3 = new JButton("修改");
        button4 = new JButton("删除");
        button5 = new JButton("增加");
        button1 = new JButton("查询");
        panel2 = new JPanel();
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button1);

        this.setLayout(new GridLayout(2,1));
        this.add(scrollPane);
        this.add(panel2);
        addListen();
    }
    public void updateData() {
        StudentService studentService = new StudentService();
        infoTable.list = studentService.list();
        jTable.updateUI();
        jTable.getSelectionModel().setSelectionInterval(0, 0);

        if(0==infoTable.list.size()){
           button3.setEnabled(false);
           button4.setEnabled(false);
           button5.setEnabled(false);
           button1.setEnabled(false);
        }
        else{
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button1.setEnabled(true);
        }
    }
    public void addListen()
    {
        button3.addActionListener(new InfoListener());
        button4.addActionListener(new InfoListener());
        button5.addActionListener(new InfoListener());
        button1.addActionListener(new InfoListener());
    }
    public static void main(String[] args) {
        InfoPanel infoPanel = InfoPanel.getInstance();
        GUIUtil.showPanel(infoPanel);
    }
}
