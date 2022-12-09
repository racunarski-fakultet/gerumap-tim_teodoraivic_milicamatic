package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Position;

public class Concept extends Element{

    private Element e;
    String name;
    private Position position;
    private int size;
    float x,y; //koordinate getpoints metoda
    float width=20;
    float height=20;


    //pozicija i size


    public Concept(String name, MapNode parent) {
        super(name, parent);
    }

    public Concept(String name, MapNode parent, float x, float y) {
        super(name, parent);
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
