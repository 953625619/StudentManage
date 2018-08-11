package GUI.Listener;

import DAO.SelectDAO;
import GUI.Frame.MainFrame;
import GUI.Panel.StuCoursePanel;
import service.SelectService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        StuCoursePanel stuCoursePanel = StuCoursePanel.getInstance();
        JButton button = (JButton)e.getSource();
        if(stuCoursePanel.button1 == button)
        {
            SelectService selectService = new SelectService();
            String sno = MainFrame.getInstance().config.getUser();
            String cno = (String) stuCoursePanel.table1.getValueAt(stuCoursePanel.table1.getSelectedRow(),0);
            selectService.delete(sno,cno);
            stuCoursePanel.update();
        }
        else if(button == stuCoursePanel.button2)
        {
            SelectService selectService = new SelectService();
            String sno = MainFrame.getInstance().config.getUser();
            String cno = (String) stuCoursePanel.table2.getValueAt(stuCoursePanel.table2.getSelectedRow(),0);
            selectService.add(sno,cno);
            stuCoursePanel.update();

        }

    }
}
