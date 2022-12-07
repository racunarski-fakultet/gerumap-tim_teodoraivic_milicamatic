package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.core.NodeFactory;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Element;

public class ElementFactory extends Factory implements NodeFactory {


    @Override
    public MapNode getNode() {
        return null;
    }

    @Override
    public MapNode createNode(String naziv, MapNode parent) {
       // MapNode element=new Element(naziv,parent);
        return element;
    }
}
