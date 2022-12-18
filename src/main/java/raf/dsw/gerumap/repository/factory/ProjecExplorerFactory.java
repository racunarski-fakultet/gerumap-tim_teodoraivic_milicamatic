package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.core.NodeFactory;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public class ProjecExplorerFactory extends Factory implements NodeFactory {


    @Override
    public MapNode getNode() {
        return null;
    }


    @Override
    public MapNode createNode(String naziv, MapNode parent) {
        MapNode projectExplorer=new ProjectExplorer(naziv);
        return projectExplorer;
    }
}
