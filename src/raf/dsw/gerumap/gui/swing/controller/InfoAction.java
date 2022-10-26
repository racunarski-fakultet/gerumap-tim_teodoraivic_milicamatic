package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;



public class InfoAction extends AbstractGeRuMapAction{

    public InfoAction(){

        putValue(SMALL_ICON, loadIcon("../images/info11.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
