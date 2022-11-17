package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class TabbedPane extends JTabbedPane{


    private List<JPanel> tabs;

    //private List<MapNode> maps ; //kako inicijalizovati ovo da ne bude null;

    private ProjectView projectView;



    public TabbedPane(ProjectView projectView) {

        this.projectView = projectView;

        tabs = new ArrayList<>();

        for (MapNode map : projectView.getMaps()){
                JPanel pan = new JPanel(); //pravi novi panel

                this.addTab(map.getName(),pan); // dodaj panel na tabbedpane

            }

        //for(JPanel panels : tabs){

           // this.addTab("name", panels);

        //}


    }

    ///@Override
    //public void update(Object notification) {
       // if(notification.equals("mape projekta uzete")){
           // this.setMaps(projectView.getProject().getMape(projectView.getProject()));
            // proveri dal getproject vraca project

       // }
    //}

   // public void setMaps(List<MapNode> maps) {
    //    this.maps = maps;
    //}
}
