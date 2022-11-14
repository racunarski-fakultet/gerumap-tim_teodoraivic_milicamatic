package raf.dsw.gerumap.gui.swing.view;

import javax.accessibility.Accessible;
import javax.swing.*;

public class OptionPane extends JOptionPane{

    //optionpane zovem kad GUI-u koji je subscriber za mesGen stigne update

    JFrame f;

    public OptionPane(String notification) {
        f=new JFrame();
        JOptionPane.showMessageDialog(f, "option pane");
    }

}
