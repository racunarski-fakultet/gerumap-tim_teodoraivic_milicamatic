package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.core.NodeFactory;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

public class ProjectFactory extends Factory implements NodeFactory {

    @Override
    public MapNode getNode() {
        return null;
    }

    @Override
    public MapNode createNode(String naziv, MapNode parent) {
        MapNode project= new Project(naziv,parent);
        return project;
    }
}
