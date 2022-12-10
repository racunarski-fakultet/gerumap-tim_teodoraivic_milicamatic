package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Connection extends Element{ //model

    private Concept from;
    private Concept to;
    int stroke; //defaultno



    public Connection(String name, MapNode parent) {
        super(name, parent);
    }
}
