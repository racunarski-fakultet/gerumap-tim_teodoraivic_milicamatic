package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractGeRuMapAction{

    public MoveAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(SHORT_DESCRIPTION, "Move");

    }
}
