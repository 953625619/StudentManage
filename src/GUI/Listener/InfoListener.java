package GUI.Listener;

import GUI.Dialog.AddDialog;
import GUI.Dialog.EditDialog;
import GUI.Dialog.QuireDialog;
import GUI.Frame.TecFrame;
import GUI.Panel.InfoPanel;
import Util.GUIUtil;
import entity.Student;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        InfoPanel infoPanel = InfoPanel.getInstance();
        JButton button = (JButton)e.getSource();
        StudentService studentService = new StudentService();
        if(button == infoPanel.button1)
            new QuireDialog();
        if(button==infoPanel.button3)
        {
            JTable table = infoPanel.jTable;
            if(table.getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "请先选择一行！");
                return;
            }
            else
             new EditDialog();

        }
        if(button==infoPanel.button4)
        {
            int a = infoPanel.jTable.getSelectedRow();
            Object obj =  infoPanel.jTable.getValueAt(infoPanel.jTable.getSelectedRow(),0);
            String sno = (String) obj;
            int b = JOptionPane.showConfirmDialog(null,"是否确定？");
            if(b == JOptionPane.YES_OPTION) {
                studentService.delete(sno);
                infoPanel.updateData();
            }else if(b == JOptionPane.NO_OPTION)
                return;
        }
        if(button==infoPanel.button5)
        {
            new AddDialog();
        }


    }
}
