package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.state.State;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectView extends JPanel implements ISubscriber {

    

    private Project project;

    private JLabel nameLbl;

    private JLabel autorLbl;

    private TabbedPane tp;

    private List<MapNode> maps;

    private Toolbar2 toolbar2;

    private List<MapView> mapViews=new ArrayList<>();

    private MapView mapView;

    private MindMap mindMap;

    public StateManager sm;
    //pv prenosi korisnicku akciju ka stete-u // pv je mediator
    //mediator prihvata nas klik i kaze state manager-u sta da radi dalje



    public ProjectView(Project project) {
        this.project = project;
        this.project.addSubs(this);                //projectView je sub za project(MapNode)
        nameLbl = new JLabel(project.getName());
        autorLbl = new JLabel(project.getAutor());

        setLayout(new BorderLayout());
        add(nameLbl, BorderLayout.NORTH);
        add(autorLbl, BorderLayout.SOUTH);

        sm=new StateManager();
        toolbar2=new Toolbar2();
        add(toolbar2,BorderLayout.EAST);

    }

    public void setTabbedPane(){
        if(tp != null) {
            this.remove(tp);
        }
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
        if(notification.equals("mindmap added")){ //Za elemente
            this.setMaps(project.getChildren());
        }

    }

    public State getCurrentState(){
        return this.sm.getCurrent();
    }


    public void startConceptState() { this.sm.setConceptState(); }
    public void startConnectionState(){
        this.sm.setConnectionState();
    }
    public void startDeleteState(){
        this.sm.setDeleteState();
    }
    public void startSelectionState(){
        this.sm.setSelectionState();
    }
    public void startMoveState(){
        this.sm.setMoveState();
    }



    public void misKliknut(int x, int y, MapView mapView){
        this.sm.getCurrent().misKliknut(x,y,mapView);
    }

    public void misPritisnut(int x, int y, MapView mapView){
        this.sm.getCurrent().misPritisnut(x,y,mapView);
    }
    public void misPusten(int x,int y, MapView mapView){
        this.sm.getCurrent().misPusten(x,y,mapView);
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

    public List<MapView> getMapViews() {
        return mapViews;
    }

    public MapView getMapView() {
        return mapView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectView that = (ProjectView) o;

        return Objects.equals(project, that.project);
    }

    @Override
    public String toString() {
        return "ProjectView{" +
                "project=" + project +
                ", nameLbl=" + nameLbl +
                ", tp=" + tp +
                ", maps=" + maps +
                ", mapViews=" + mapViews +
                '}';
    }
}
