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

//        if (e.getClickCount()==1) {
//            int index = projectView.getTp().getSelectedIndex();
//
//            // projectView.getTp().setComponentAt(index,projectView.getMapViews().get(index));
//
//            projectView.getTp().setComponentAt(index,projectView.getMapViews().get(index));
//
//        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

        int selectedIndex = projectView.getTp().getSelectedIndex();

        projectView.misKliknut(e.getX(), e.getY(),(MapView) projectView.getMapViews().get(selectedIndex));

        //kada se desi press uzmi mediatora i aktiviraj analognu metodu za nas trenutni state
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
