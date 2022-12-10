package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;

public abstract class Element extends MapNode { //model

    private Paint colour;
    private int stroke=10; //debljina linije

    //treba da ima x,y koord, w i h, i tekst, concept to nasledjuje


    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Paint getColour() {
        return colour;
    }

    public void setColour(Paint colour) {
        this.colour = colour;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }
}
