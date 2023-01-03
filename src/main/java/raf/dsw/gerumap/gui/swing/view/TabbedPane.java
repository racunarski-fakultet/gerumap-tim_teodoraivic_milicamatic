package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TabbedPane extends JTabbedPane{


    private List<JPanel> tabs;

    private MapView mapView;
    private ProjectView projectView;


    public TabbedPane(ProjectView projectView) {

        this.projectView = projectView;

        tabs = new ArrayList<>();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();


        Dimension min  = new Dimension(200,100);
        Dimension max = new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);
        Dimension pref = new Dimension(400,200);





        for (MapNode map : projectView.getMaps()){

            JPanel pan = new JPanel();//pravi novi panel

            //pravim mapView za svaki mindMap
            //to do update kad se dodaju nove mape

             mapView = new MapView(new FlowLayout(), true, (MindMap) map, projectView);
             mapView.setMindMap((MindMap) map);


            projectView.getMapViews().add(mapView);

             pan.setMinimumSize(min);
             pan.setMaximumSize(max);
             pan.setPreferredSize(pref);


            this.addTab(map.getName(), pan);
            this.setComponentAt(this.getTabCount()-1,mapView);


            }


    }

    public void addATab(MindMap map){
        Dimension min  = new Dimension(200,100);
        Dimension max = new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);
        Dimension pref = new Dimension(400,200);

        JPanel pan = new JPanel();//pravi novi panel

        //pravim mapView za svaki mindMap
        //to do update kad se dodaju nove mape

        mapView = new MapView(new FlowLayout(), true, map, projectView);
        mapView.setMindMap((MindMap) map);


        projectView.getMapViews().add(mapView);

        pan.setMinimumSize(min);
        pan.setMaximumSize(max);
        pan.setPreferredSize(pref);

        this.addTab(map.getName(), pan);
        this.setComponentAt(this.getTabCount()-1,mapView);

    }

    public void setTabs(){

    }


}
