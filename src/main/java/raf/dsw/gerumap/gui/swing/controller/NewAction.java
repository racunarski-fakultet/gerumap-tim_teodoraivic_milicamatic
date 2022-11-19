package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class NewAction extends AbstractGeRuMapAction{

    public NewAction(){
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

        MainFrame.getInstance().getMapTree().addChild(selected);



        if(mapNode instanceof MindMap){

            ProjectView projectView = m.getProjectView();

            if(projectView != null){
                projectView.getTp().removeAll();
                projectView.setTabbedPane();
            }

            JPanel desktop = m.getDesktop();

            desktop.revalidate();
        }

    }
}
