package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Position;

public class Concept extends Element{

    String name;
    private Position position;
    private int size;


    //pozicija i size


    public Concept(String name, MapNode parent) {
        super(name, parent);
    }
}
