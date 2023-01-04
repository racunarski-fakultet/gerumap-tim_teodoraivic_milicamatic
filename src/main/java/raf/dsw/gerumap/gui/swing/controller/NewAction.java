package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractGeRuMapAction {

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        MainFrame m = MainFrame.getInstance();

        MapTreeItem selected = m.getMapTree().getSelectedNode();

        MapNode mapNode = selected.getMapNode();

        MainFrame.getInstance().showCurrentProjectView();

        MainFrame.getInstance().getMapTree().addChild(selected);

        ProjectView projectView = m.getProjectView();


        if (mapNode instanceof Project) {


            if (projectView != null) {

                MainFrame.getInstance().addNewMindMap();


            }

        }
    }
}
