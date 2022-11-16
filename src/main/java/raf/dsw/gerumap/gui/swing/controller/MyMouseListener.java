package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.gui.swing.view.TabbedPane;
import raf.dsw.gerumap.repository.implementation.Project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project){
                ProjectView pv = new ProjectView((Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
                TabbedPane tp = new TabbedPane(pv, pv.getProject().getMape(pv.getProject()));

                MainFrame.getInstance().getDesktop().add(pv);
                pv.add(tp);
                tp.setVisible(true);
                MainFrame.getInstance().getDesktop().revalidate();
                System.out.println(pv);
            }
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
