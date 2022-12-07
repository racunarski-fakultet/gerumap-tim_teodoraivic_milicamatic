package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectionAction extends AbstractGeRuMapAction{

    public SelectionAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(SHORT_DESCRIPTION, "Select");

        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startSelectionState();

    }
}
