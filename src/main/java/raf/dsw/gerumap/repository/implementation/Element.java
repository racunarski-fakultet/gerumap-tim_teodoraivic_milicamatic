package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;

public abstract class Element extends MapNode {

    private Paint colour;
    private Stroke stroke;


    public Element(String name, MapNode parent) {
        super(name, parent);
    }


}
