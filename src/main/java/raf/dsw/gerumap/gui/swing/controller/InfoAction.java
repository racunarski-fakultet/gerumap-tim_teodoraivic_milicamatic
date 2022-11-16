package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;



public class InfoAction extends AbstractGeRuMapAction{


    public InfoAction(){

        putValue(SMALL_ICON, loadIcon("/images/info2.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getInfoDialog().setVisible(true);
    }
}
