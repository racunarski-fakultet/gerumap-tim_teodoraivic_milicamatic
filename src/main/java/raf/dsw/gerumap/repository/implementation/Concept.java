package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Position;

public class Concept extends Element{ //model

    private Element e;
    String name;
    private int size;
    float x,y; //koordinate getpoints metoda
    float width=20;
    float height=20;



   //koordinate uzimam iz metode


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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
