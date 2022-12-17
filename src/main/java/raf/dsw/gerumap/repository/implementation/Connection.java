package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;
import java.util.ArrayList;

public class Connection extends Element{ //model

    private Concept fromConcept;
    private Concept toConcept;

    private Paint color;

    float x1,y1,x2,y2;
    //x1 i x2 cu da uzmem iz mouse pressed pocetne a x2 i y2 iz mouse released


    public Connection(String name, MapNode parent,float x1, float y1, float x2, float y2) {
        super(name, parent);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Connection(String name, MapNode parent,Paint color,int stroke) {

        super(name,parent,color,stroke);




    }

    public Connection(String name, MapNode parent) {
       super(name, parent);
    }

    public Concept getFromConcept() {
        return fromConcept;
    }

    public void setFromConcept(Concept fromConcept) {
        this.fromConcept = fromConcept;
    }

    public Concept getToConcept() {
        return toConcept;
    }

    public void setToConcept(Concept toConcept) {
        this.toConcept = toConcept;
    }

    public void setTo(float x, float y) {

        setX2(x);
        setY2(y);
        notifySubscribers("krajnje koord");
       // System.out.println("prosledjena noti za krajnje kord");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Connection that = (Connection) o;

        if (Float.compare(that.x1, x1) != 0) return false;
        if (Float.compare(that.y1, y1) != 0) return false;
        if (Float.compare(that.x2, x2) != 0) return false;
        return Float.compare(that.y2, y2) == 0;
    }
}
