package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    

    private Project project;

    private JLabel nameLbl;

    private JLabel autorLbl;

    private TabbedPane tp;

    private List<MapNode> maps;

    private Toolbar2 toolbar2;

    private StateManager sm;



    public ProjectView(Project project) {
        this.project = project;
        this.project.addSubs(this);                //projectView je sub za project(MapNode)
        nameLbl = new JLabel(project.getName());
        autorLbl = new JLabel(project.getAutor());

        setLayout(new BorderLayout());
        add(nameLbl, BorderLayout.NORTH);
        add(autorLbl, BorderLayout.SOUTH);

        toolbar2=new Toolbar2();
        add(toolbar2,BorderLayout.EAST);

    }

    public void setTabbedPane(){
        tp = new TabbedPane(this);
        add(tp, BorderLayout.CENTER);
        tp.setVisible(true);
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
        if(notification.equals("mindmap removed")) {
            this.setMaps(project.getChildren());

        }
        if(notification.equals("mindmap added")){ // TODO zahteva dupli klik na project da bi se refrshovao tabbed popraviti
            this.setMaps(project.getChildren());
        }

    }

    public void startConceptState(){
        this.sm.setConceptState();
    }
    public void startConnectionState(){
        this.sm.setConceptState();
    }
    public void startDeleteState(){
        this.sm.setDeleteState();
    }
    public void startSelectionState(){
        this.sm.setConnectionState();
    }
    public TabbedPane getTp() {
        return tp;
    }

    public List<MapNode> getMaps() {
        return maps;
    }

    public void setMaps(List<MapNode> maps) {
        this.maps = maps;
    }
}
