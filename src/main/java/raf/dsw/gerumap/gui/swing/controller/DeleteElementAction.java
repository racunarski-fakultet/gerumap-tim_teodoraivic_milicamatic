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


        putValue(SMALL_ICON, loadIcon("/images/delete1.png"));
        putValue(SHORT_DESCRIPTION, "Delete");

        MainFrame m = MainFrame.getInstance(); //nasa aplikacija

        ProjectView projectView = m.getProjectView(); //nas mediator

        projectView.startDeleteState(); //zapocni stanje brisanja

        projectView.getCurrentState();

    }
}


