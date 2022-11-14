package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String autor;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child!=null && child instanceof MindMap){
            MindMap mindMap=(MindMap) child;
            if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
            }
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
    }
}
