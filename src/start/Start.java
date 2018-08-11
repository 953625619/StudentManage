package start;

import GUI.Frame.MainFrame;
import Util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Start {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.getInstance();
            }
        });
    }
}
