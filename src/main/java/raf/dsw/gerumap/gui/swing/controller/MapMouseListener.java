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

       // projectView.misKliknut(e.getX(), e.getY(),(MapView) projectView.getTp().getSelectedComponent());
        //kada se desi press uzmi mediatora i aktiviraj analognu metodu za nas trenutni state

    }

    @Override
    public void mousePressed(MouseEvent e) {

        projectView.misKliknut(e.getX(), e.getY(),(MapView) projectView.getTp().getSelectedComponent());
        //uzima x1,y1 za line2D

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        projectView.misPusten(e.getX(), e.getY(),(MapView) projectView.getTp().getSelectedComponent());
        //uzima x2,y2 za line2D

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
