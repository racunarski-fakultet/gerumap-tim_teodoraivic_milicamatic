package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MyMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){

            MainFrame m = MainFrame.getInstance();

            MainFrame.getInstance().showCurrentProjectView(); //iz mainframe inicijalizuje novi

            //ProjectView projectView = m.getProjectView();

            //Project project = projectView.getProject(); //uzima project iz project viewa

            //System.out.println(project);

            //List<MapNode> children = project.getChildren(); //uzima decu iz projecta

            //System.out.println(children);

            //projectView.setMaps(children); //setuje mape koje koristi tabbed pane za nove mape

            //projectView.setTabbedPane(); //pravi novi tabbedpane, koji pravi nove mapviewove

//






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
