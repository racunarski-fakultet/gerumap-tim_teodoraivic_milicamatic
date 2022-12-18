package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListen implements MouseMotionListener {

    MainFrame m = MainFrame.getInstance();


    ProjectView projectView = m.getProjectView();


    @Override
    public void mouseDragged(MouseEvent e) {

        projectView.misPritisnut(e.getX(),e.getY(),(MapView) projectView.getTp().getSelectedComponent());
        //pravi novu grafiku samo za ovu metodu i kao crta

//             Graphics g= m.getGraphics();
//             g.setColor(Color.BLUE);
//             g.fillOval(e.getX()+10,e.getY()+10,5,5);
//
//


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
