package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.event.ActionEvent;

import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;

public class DeleteElementAction extends AbstractGeRuMapAction{

    public DeleteElementAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startDeleteState();

        putValue(SMALL_ICON, loadIcon("/images/concept.png"));
        putValue(SHORT_DESCRIPTION, "Concept");

    }
}


