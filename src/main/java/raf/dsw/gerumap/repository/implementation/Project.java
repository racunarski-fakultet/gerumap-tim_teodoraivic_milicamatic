package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.List;

public class Project extends MapNodeComposite {

    protected String filePath;

    @JsonIgnore
     transient boolean changed = true; //svuda gde je promena na nivou projekta

     String autor;

    //@JsonIgnore
    private transient MindMap mindMap;
   //@JsonIgnore
    private transient List<MapNode> children;

    @JsonProperty
    private String type = "project";


    @JsonCreator
    public Project(@JsonProperty("name") String name,@JsonProperty("parent") MapNode parent) {
        super(name, parent);
    }

    public Project(){
        super(null,null);
    }


    @Override
    public void addChild(MapNode child) {
        if (child!=null && child instanceof MindMap){

            MindMap mindMap=(MindMap) child;
            //TODO fix & override contains
           // if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
                changed=true;
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
                changed=true;
            }
        }
    }


    //@JsonGetter
    public String getAutor() {
        return autor;
    }

    //@JsonSetter
    public void setAutor(String autor) {
        this.autor = autor;
        changed=true;
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

    @JsonGetter
    public String getFilePath() {
        return filePath;
    }

    @JsonSetter
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonIgnore
    public boolean isChanged() {
        return changed;
    }

    @JsonIgnore
    public void setChanged(boolean changed) {
        this.changed = changed;
    }


}
