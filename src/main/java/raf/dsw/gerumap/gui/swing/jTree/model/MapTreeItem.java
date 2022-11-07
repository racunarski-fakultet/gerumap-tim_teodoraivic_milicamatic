package raf.dsw.gerumap.gui.swing.jTree.model;

import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel){
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public MapNode getMapNode() {
        return mapNode;
    }

    public void setMapNode(MapNode mapNode) {
        this.mapNode = mapNode;
    }

    public void setName(String name){
        this.mapNode.setName(name);


    }
}
