package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.LoggerInterface;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageGenImpl;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.OptionPane;

public class SwingGui implements GUI, ISubscriber, LoggerInterface {


    public MainFrame mainFrame;

    public SwingGui(MessageGenImpl messageGen){
        messageGen.addSubs(this);

    }


    @Override
    public void start() {
        mainFrame=MainFrame.getInstance();
        mainFrame.setVisible(true);
    }



    @Override
    public void log(Message message) {
        OptionPane optionPane=new OptionPane(message);

    }


    @Override
    public void update(Object notification) {
        log((Message) notification);
    }


}
