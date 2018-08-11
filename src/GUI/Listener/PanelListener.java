package GUI.Listener;


import GUI.Frame.TecFrame;
import GUI.Panel.GradePanel;
import GUI.Panel.InfoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TecFrame frame = TecFrame.getInstance();
        JButton button = (JButton)e.getSource();
        if(button==frame.button1)
            frame.workPanel.show(InfoPanel.getInstance());
        else if ((button == frame.button2))
            frame.workPanel.show(GradePanel.getInstance());
    }
}
