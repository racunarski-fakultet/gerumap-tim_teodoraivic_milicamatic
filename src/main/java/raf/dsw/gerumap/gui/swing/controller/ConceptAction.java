package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class ConceptAction extends AbstractGeRuMapAction{

    public ConceptAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        putValue(SMALL_ICON, loadIcon("/images/concept.png"));
        putValue(SHORT_DESCRIPTION, "Concept");

    }
}
