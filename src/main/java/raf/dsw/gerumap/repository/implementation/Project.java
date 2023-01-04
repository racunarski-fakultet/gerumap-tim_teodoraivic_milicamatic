package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.List;
import java.util.Objects;

public class Project extends MapNodeComposite {

    protected String filePath;

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
                this.getParent().setChanged(true);
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
                this.getParent().setChanged(true);
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
        //this.getParent().setChanged(true);
        notifySubscribers("author changed");
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode){

            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName()) && this.getParent().equals(otherObj.getParent());
        }
        return false;
    }



    @Override
    public int hashCode() {
        return children != null ? children.hashCode() : 0;
    }

    @JsonGetter
    public String getFilePath() {
        return filePath;
    }

    @JsonSetter
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }




}
