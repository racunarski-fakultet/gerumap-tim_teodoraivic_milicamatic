package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Concept extends Element{

    String name;
    //pozicija i size


    public Concept(String name, MapNode parent) {
        super(name, parent);
    }
}
