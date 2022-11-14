package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;

public class ProjectView extends JPanel implements ISubscriber {

    private Project project;

    private JLabel nameLbl;

    private JLabel autorLbl;

    //private JTabbedPane tabbedPane;



    public ProjectView(Project project) {
        this.project = project;
        this.project.addSubs(this);                //projectView je sub za project(MapNode)
        nameLbl = new JLabel(project.getName());
        autorLbl = new JLabel(project.getAutor());

        add(nameLbl);
        add(autorLbl);
    }

    public Project getProject() {
        return project;
    }


    @Override
    public void update(Object notification) {
        if(notification.equals("name changed")) {
            nameLbl.setText(project.getName());
        }
        if(notification.equals("author changed")){
            autorLbl.setText(project.getAutor());
        }

    }


}
