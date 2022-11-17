package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    

    private Project project;

    private JLabel nameLbl;

    private JLabel autorLbl;

    private TabbedPane tp;

    private List<MapNode> maps; // kad napravim pv da setujem ovo
    //pa onda pravim tb





    public ProjectView(Project project) { //kako da odma incijalizujem listu mapa na ono sto mi treba
        this.project = project;
        this.project.addSubs(this);                //projectView je sub za project(MapNode)
        nameLbl = new JLabel(project.getName());
        autorLbl = new JLabel(project.getAutor());
       // tp.setMaps(project.getChildren());
       // tp = new TabbedPane(this);

        add(nameLbl);
        add(autorLbl);
       // add(tp);
       // tp.setVisible(true);

    }

    public void setTabbedPane(){
        tp = new TabbedPane(this);
        this.add(tp);
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
        //if(notification.equals("children added")){
         //   this.setMaps(project.getChildren());
       // } //problem je sa getChildren i observerom mada msm samo getChildren

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
