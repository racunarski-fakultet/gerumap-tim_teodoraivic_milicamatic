package raf.dsw.gerumap.gui.swing.repository.composite;

import java.util.Objects;

public class MapNode {

    private String name;

    private MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode){
            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }



}
