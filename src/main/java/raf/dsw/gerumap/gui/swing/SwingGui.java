package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.OptionPane;

public class SwingGui implements GUI, ISubscriber {


    public MainFrame mainFrame;

    public SwingGui(){

    }


    @Override
    public void start() {
        mainFrame=MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        OptionPane optionPane=new OptionPane((String)notification);
    }


}
