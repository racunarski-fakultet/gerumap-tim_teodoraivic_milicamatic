package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractGeRuMapAction{

    public MoveAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(SHORT_DESCRIPTION, "Move");

        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startMoveState();

    }
}
