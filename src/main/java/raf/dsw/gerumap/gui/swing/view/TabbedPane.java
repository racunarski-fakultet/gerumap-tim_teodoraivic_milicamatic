package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class TabbedPane extends JTabbedPane implements ISubscriber {


    private List<JPanel> tabs;

    private List<MapNode> maps;

    private ProjectView projectView;



    public TabbedPane(ProjectView projectView, List<MapNode> maps) {

        this.projectView = projectView;

        this.projectView.getProject().addSubs(this);

        this.maps = maps;

        tabs = new ArrayList<>();

        for (MapNode map : maps){
                JPanel pan = new JPanel(); //pravi novi panel

                this.addTab(map.getName(),pan); // dodaj panel na tabbedpane

            }

        //for(JPanel panels : tabs){

           // this.addTab("name", panels);

        //}


    }

    @Override
    public void update(Object notification) {
        if(notification.equals("mape projekta uzete")){
            this.setMaps(projectView.getProject().getMape(projectView.getProject()));

        }
    }

    public void setMaps(List<MapNode> maps) {
        this.maps = maps;
    }
}
