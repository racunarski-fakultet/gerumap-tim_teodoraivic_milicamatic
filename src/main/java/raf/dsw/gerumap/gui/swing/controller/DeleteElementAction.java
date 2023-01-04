package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.event.ActionEvent;
import java.util.List;

import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;

public class DeleteElementAction extends AbstractGeRuMapAction{

    public DeleteElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/delete1.png"));
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startDeleteState();

        projectView.getCurrentState();


    }
}


