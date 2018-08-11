package GUI.Frame;

import GUI.Listener.PanelListener;
import GUI.Listener.StuPanelListener;
import Util.CenterPanel;
import Util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class StuFrame extends JFrame{
    {
        GUIUtil.useLNF();
    }
    private static final StuFrame frame = new StuFrame();
    public static StuFrame getInstance(){
        return frame;
    }
    JSplitPane pane ;
    public JButton button1;
    public JButton button2;
    JPanel panel;
    public CenterPanel workPanel;
    private StuFrame()
    {
        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        workPanel = new CenterPanel(0.8);
        button1 = new JButton("个人信息");
        button2 = new JButton("选课信息");
        GUIUtil.setImageIcon(button1,"3.png","个人信息");
        GUIUtil.setImageIcon(button2,"4.png","选课信息");
        JLabel label = new JLabel("欢迎学生！您的学号为："+MainFrame.getInstance().config.getUser());

        panel = new JPanel(new GridLayout(2,1));
        panel.add(button1);
        panel.add(button2);
        pane.add(panel);
        pane.add(workPanel);

        this.setTitle("学生系统");
        this.setContentPane(pane);
        this.setLocation(200,200);
        this.setSize(600,450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        workPanel.show(label);
        addListen();
    }
    public  void addListen()
    {
        button1.addActionListener(new StuPanelListener());
        button2.addActionListener(new StuPanelListener());
    }

    public static void main(String[] args) {
        StuFrame.getInstance();
    }
}

