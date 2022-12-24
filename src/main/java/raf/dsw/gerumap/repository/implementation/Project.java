package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project extends MapNodeComposite {

    protected String filePath;
    protected  boolean changed = true; //svuda gde je promena na nivou projekta

    private String autor;

    private MindMap mindMap;

    private List<MapNode> children;

    public Project(String name, MapNode parent) {

        super(name, parent);


    }

    @Override
    public void addChild(MapNode child) {
        if (child!=null && child instanceof MindMap){

            MindMap mindMap=(MindMap) child;
            //TODO fix & override contains
           // if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
                notifySubscribers("mindMap ADDED");
             }
      // }
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

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode){

            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
