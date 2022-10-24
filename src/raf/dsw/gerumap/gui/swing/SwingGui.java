package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

public class SwingGui implements GUI {


    public MainFrame mainFrame;

    public SwingGui(){

    }


    @Override
    public void start() {
        mainFrame=MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
