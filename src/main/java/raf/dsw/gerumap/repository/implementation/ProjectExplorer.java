package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {


    //root node
    public ProjectExplorer(String name) {
        super(name, null);
    }




    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Project){
            Project project = (Project) child;
            if (!this.getChildren().contains(project)){
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            boolean contains = getChildren().contains(project);
            if (contains) {
                this.getChildren().remove(project);
            }

        }
    }
}
