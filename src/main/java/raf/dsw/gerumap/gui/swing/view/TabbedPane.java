package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TabbedPane extends JTabbedPane{


    private List<JPanel> tabs;


    private ProjectView projectView;



    public TabbedPane(ProjectView projectView) {


        this.projectView = projectView;

        tabs = new ArrayList<>();

        Dimension min  = new Dimension(200,100);
        Dimension max = new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);
        Dimension pref = new Dimension(400,200);

        for (MapNode map : projectView.getMaps()){
                JPanel pan = new JPanel(); //pravi novi panel
                pan.setMinimumSize(min);
                pan.setMaximumSize(max);
                pan.setPreferredSize(pref);

                this.addTab(map.getName(),pan); // dodaj panel na tabbedpane

            }


    }

    public void setTabs(){

    }


}
