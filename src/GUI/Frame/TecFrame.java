package GUI.Frame;

import GUI.Listener.PanelListener;
import GUI.Panel.InfoPanel;
import Util.CenterPanel;
import Util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class TecFrame extends JFrame {
    {
        GUIUtil.useLNF();
    }
    private static final TecFrame frame = new TecFrame();
    public static TecFrame getInstance(){
        return frame;
    }
    JSplitPane pane ;
    public JButton button1;
    public JButton button2;
    JPanel panel;
    public CenterPanel workPanel;
    private TecFrame(){
        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        workPanel = new CenterPanel(0.8);
        button1 = new JButton("学生信息");
        button2 = new JButton("学生成绩");
        GUIUtil.setImageIcon(button1,"1.png","学生信息");
        GUIUtil.setImageIcon(button2,"2.png","学生成绩");

        panel = new JPanel(new GridLayout(2,1));
        panel.add(button1);
        panel.add(button2);

        pane.add(panel);
        JLabel label = new JLabel("欢迎老师！您的教师编号为："+MainFrame.getInstance().config.getUser());

        pane.add(workPanel);

        this.setTitle("教师系统");
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
        button1.addActionListener(new PanelListener());
        button2.addActionListener(new PanelListener());
    }
    public static void main(String[] args) {
        getInstance();
    }
}
