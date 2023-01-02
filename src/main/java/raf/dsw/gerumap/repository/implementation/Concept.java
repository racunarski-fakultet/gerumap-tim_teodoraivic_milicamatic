package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Position;
import java.awt.*;
import java.util.Objects;

public class Concept extends Element{ //model

    @JsonIgnore
    private Element e;
    //String name;
    @JsonIgnore
    transient private int size;
    float x,y; //koordinate getpoints metoda
    float width=60;
    float height=35;

    private String type = "concept";




    //koordinate uzimam iz metode


    public Concept(String name, MapNode parent) {
        super(name, parent);
    }

    public Concept(String name, MapNode parent, float x, float y) {
        super(name,parent);
       // this.name = name;
        this.x = x;
        this.y = y;
    }
    public Concept(String name, MapNode parent, Integer color,int stroke, float x, float y) {
        super(name,parent,color,stroke);
       // this.name = name;
        this.x = x;
        this.y = y;
    }

    @JsonGetter
    public float getX() {
        return x;
    }
    @JsonSetter
    public void setX(float x) {
        this.x = x;
    }
    @JsonGetter
    public float getY() {
        return y;
    }

    @JsonSetter
    public void setY(float y) {
        this.y = y;
    }

    @JsonGetter
    public float getWidth() {
        return width;
    }
    @JsonSetter
    public void setWidth(float width) {
        this.width = width;
    }
    @JsonGetter
    public float getHeight() {
        return height;
    }

    @JsonSetter
    public void setHeight(float height) {
        this.height = height;
    }

//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name = name;
//    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @JsonGetter
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Concept{" +
                "name='" + super.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Concept concept = (Concept) o;

        if (Float.compare(concept.x, x) != 0) return false;
        return Float.compare(concept.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }
}
