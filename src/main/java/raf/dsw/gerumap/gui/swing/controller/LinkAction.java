package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.event.ActionEvent;

public class LinkAction extends AbstractGeRuMapAction{
    public LinkAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        putValue(SMALL_ICON, loadIcon("/images/link.png"));
        putValue(SHORT_DESCRIPTION, "link");

        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startConnectionState();

        projectView.getCurrentState();

    }
}
