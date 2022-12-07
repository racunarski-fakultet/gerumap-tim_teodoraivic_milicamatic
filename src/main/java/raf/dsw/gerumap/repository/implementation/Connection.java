package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Connection extends Element{

    private Concept from;
    private Concept to;


    public Connection(String name, MapNode parent) {
        super(name, parent);
    }
}
