package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;

public class ProjectView extends JPanel {

    private Project project;

    private JLabel nameLbl;

    private JLabel autorLbl;

    public ProjectView(Project project) {
        this.project = project;
        nameLbl = new JLabel(project.getName());
        autorLbl = new JLabel(project.getAutor());
        add(nameLbl);
        add(autorLbl);
    }

    public Project getProject() {
        return project;
    }




}
