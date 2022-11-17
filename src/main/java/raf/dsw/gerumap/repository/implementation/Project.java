package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Project extends MapNodeComposite {

    private String autor;

    private MindMap mindMap;

    private List<MapNode> children;

    public Project(String name, MapNode parent) {

        super(name, parent);

        //mindMap = new MindMap(ime, this);

    }

    @Override
    public void addChild(MapNode child) {
        if (child!=null && child instanceof MindMap){
            MindMap mindMap=(MindMap) child;
            // TODO fix & override contains
//            if (!this.getChildren().contains(mindMap)){
                System.out.println("here");
                this.getChildren().add(mindMap);
//            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child!=null && child instanceof MindMap){
            MindMap mindMap=(MindMap) child;
            boolean contains= getChildren().contains(mindMap);
            if (contains){
                this.getChildren().remove(mindMap);
            }
        }
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers("author changed");
    }

    public List<MapNode> getMape() {
        //notifySubscribers("mape projekta uzete");
        System.out.println(getChildren()); //probelm u update notify i get mape
        return getChildren();
    }


}
