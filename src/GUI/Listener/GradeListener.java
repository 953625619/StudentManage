package GUI.Listener;

import GUI.Dialog.GradeDialog;
import GUI.Panel.GradePanel;
import entity.Grade;
import service.GradeService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GradePanel panel = GradePanel.getInstance();
        GradeService service = new GradeService();
        JButton button = (JButton)e.getSource();
        if(button == panel.button1)
            new GradeDialog();
        if(button == panel.button3)
        {
            int res = JOptionPane.showConfirmDialog(null,"是否删除");
            if(res==JOptionPane.YES_OPTION)
            {
                String sno =(String) panel.jTable.getValueAt(panel.jTable.getSelectedRow(),0);
                String cno =(String) panel.jTable.getValueAt(panel.jTable.getSelectedRow(),1);
                service.delete(sno,cno);
            }
            panel.updateDate();
        }
        if(button == panel.button2)
        {
            String res = JOptionPane.showInputDialog("请输入修改的成绩");
            double grade = Double.parseDouble(res);
            String sno =(String) panel.jTable.getValueAt(panel.jTable.getSelectedRow(),0);
            service.update(grade,sno);
            panel.updateDate();
        }


    }
}
