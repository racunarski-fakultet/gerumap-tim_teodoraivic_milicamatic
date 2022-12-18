package raf.dsw.gerumap.repository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        //to do: implement method
    }

    public MapRepositoryImpl(){
        projectExplorer=new ProjectExplorer("My project explorer ");

    }
}
