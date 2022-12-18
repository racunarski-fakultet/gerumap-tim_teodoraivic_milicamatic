package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectionAction extends AbstractGeRuMapAction{

    public SelectionAction() {
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(SHORT_DESCRIPTION, "Select");

    }

    @Override
    public void actionPerformed(ActionEvent e) {





        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startSelectionState();

    }
}
