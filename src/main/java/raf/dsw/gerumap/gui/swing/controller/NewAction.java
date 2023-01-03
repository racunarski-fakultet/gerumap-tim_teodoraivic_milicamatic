package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
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

        MainFrame.getInstance().showCurrentProjectView();

        MainFrame.getInstance().getMapTree().addChild(selected);

        ProjectView projectView = m.getProjectView();







        if(mapNode instanceof Project){




            if(projectView != null){

                MainFrame.getInstance().addNewMindMap();

//                projectView.setMaps(projectView.getProject().getChildren());
//                //projectView.getTp().removeAll();
//                //projectView.remove(projectView.getTp());
//                projectView.getMapViews().clear();
//                projectView.setTabbedPane();
//                projectView.repaint();
//
//
//                for (MapView mapView: projectView.getMapViews()){
//                    mapView.repaint();
//                }
//                for (MapNode mp :  projectView.getProject().getChildren()){
//                    MindMap mm=(MindMap) mp;
//                    mm.repaintMapview();
//                }
//
//                MindMap mp=(MindMap)projectView.getProject().getChildren().get(0);
//                System.out.println("IZ NEW ACTION "+ mp.getElements());
//                System.out.println("new act "+projectView.getProject().getChildren());
//                System.out.println(projectView.getMapViews().size());
            }



//            JPanel desktop = m.getDesktop();
//
//            desktop.revalidate();
//            desktop.repaint();
        }

    }
}
