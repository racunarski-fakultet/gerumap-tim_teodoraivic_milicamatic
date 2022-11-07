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
}
