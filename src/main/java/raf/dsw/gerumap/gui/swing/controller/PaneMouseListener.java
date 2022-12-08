package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaneMouseListener implements MouseListener {

    MainFrame m = MainFrame.getInstance();


    ProjectView projectView = m.getProjectView();

    MapView mapView = m.getProjectView().getMapView();
    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {

        projectView.misKliknut(e.getX(), e.getY(), mapView);
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
