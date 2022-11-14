package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class AutorAction extends AbstractGeRuMapAction{

    public AutorAction() {
        putValue(SMALL_ICON, loadIcon("/images/autor.png"));
        putValue(NAME, "Set Autor");
        putValue(SHORT_DESCRIPTION, "Autor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
