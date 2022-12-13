package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Connection extends Element{ //model

    private Concept from;
    private Concept to;

    float x1,y1,x2,y2;
    //x1 i x2 cu da uzmem iz mouse pressed pocetne a x2 i y2 iz mouse released


    public Connection(String name, MapNode parent, float x1, float y1, float x2, float y2) {
        super(name, parent);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Connection(String name, MapNode parent) {
        super(name, parent);
    }

    public Concept getFrom() {
        return from;
    }

    public void setFrom(Concept from) {
        this.from = from;
    }

    public Concept getTo() {
        return to;
    }

    public void setTo(Concept to) {
        this.to = to;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
}
