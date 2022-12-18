package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.gui.swing.message.Message;
import javax.swing.*;

public class OptionPane extends JOptionPane{


    JFrame f;

    public OptionPane(Message message) {
        f=new JFrame();
        JOptionPane.showMessageDialog(f,message.getMessageContent());
    }

}
