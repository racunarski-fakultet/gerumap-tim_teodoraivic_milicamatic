package raf.dsw.gerumap.repository.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNodeComposite extends MapNode {

    List <MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    public MapNodeComposite(String name, MapNode parent, List<MapNode> children) {
        super(name, parent);
        this.children = children;
    }


    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }

    public abstract void addChild(MapNode child);

    public MapNode getChildByName(String name){
        for (MapNode child: this.getChildren()){
            if (name.equals(child.getName())){
                return child;
            }
        }
        return null;
    }

    //brisanje dece

}


