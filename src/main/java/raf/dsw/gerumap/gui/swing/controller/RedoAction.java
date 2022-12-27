package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AppCore.getInstance().getGui().getCommandManager().doCommand();


    }
}
