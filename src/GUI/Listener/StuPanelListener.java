package GUI.Listener;

import GUI.Frame.StuFrame;
import GUI.Panel.StuCoursePanel;
import GUI.Panel.StuInfoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuPanelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        StuFrame frame = StuFrame.getInstance();
        JButton button = (JButton)e.getSource();
        if(button==frame.button1)
            frame.workPanel.show(StuInfoPanel.getInstance());
        else if ((button == frame.button2))
            frame.workPanel.show(StuCoursePanel.getInstance());
    }
}
