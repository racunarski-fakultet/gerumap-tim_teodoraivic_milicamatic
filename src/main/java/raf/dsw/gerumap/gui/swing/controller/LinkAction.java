package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class LinkAction extends AbstractGeRuMapAction{
    public LinkAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        putValue(SMALL_ICON, loadIcon("/images/link.png"));
        putValue(SHORT_DESCRIPTION, "link");

    }
}
