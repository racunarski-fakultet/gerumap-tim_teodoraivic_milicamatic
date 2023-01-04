package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGeRuMapAction{

    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getGui().getCommandManager().undoCommand();

    }
}
