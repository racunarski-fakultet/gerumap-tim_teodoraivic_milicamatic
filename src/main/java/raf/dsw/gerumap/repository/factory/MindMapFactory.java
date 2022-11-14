package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.core.NodeFactory;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;

public class MindMapFactory extends Factory implements NodeFactory {

    @Override
    public MapNode getNode() {
        return null;
    }



    @Override
    public MapNode createNode(String naziv, MapNode parent) {
        MapNode mindMap=new Element(naziv,parent);
        return mindMap;
    }
}
