package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapMouseListener implements MouseListener {

    MainFrame m = MainFrame.getInstance();


    ProjectView projectView = m.getProjectView();


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


        projectView.misKliknut(e.getX(), e.getY(),(MapView) projectView.getTp().getSelectedComponent());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        projectView.misPusten(e.getX(), e.getY(),(MapView) projectView.getTp().getSelectedComponent());

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
