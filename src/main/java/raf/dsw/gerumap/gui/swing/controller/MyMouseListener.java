package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.gui.swing.view.TabbedPane;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MyMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){

            MainFrame m = MainFrame.getInstance();

            MainFrame.getInstance().showCurrentProjectView();

            ProjectView projectView = m.getProjectView();

            Project project = projectView.getProject();

            System.out.println(project);

            List<MapNode> children = project.getChildren();

            System.out.println(children);

            projectView.setMaps(children);

            projectView.setTabbedPane();


            projectView.getTp().setComponentAt(0,projectView.getMapViews().get(0));


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
