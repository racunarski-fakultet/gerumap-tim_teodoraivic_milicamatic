package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonSetter;
import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Element extends MapNode {

    @JsonIgnore
    private int colour;
    @JsonIgnore
    transient private List<Integer>colorLista;


    private int stroke;
    @JsonIgnore
     private transient Element selectedElement = null;



    public Element(String name, MapNode parent) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        colorLista.add(0x000000);


    }

    public Element(String name, MapNode parent,Integer color,int stroke) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        this.colorLista.add(color);
        this.stroke = stroke;

    }

    @JsonGetter
    public Integer getCurrentColor(){
        return colorLista.get(colorLista.size()-1);
    }

    public void restorePreviousColor(){
        //pretposlednji postaje poslednji
         colorLista.remove(colorLista.size()-1);
        notifySubscribers("color changed");

    }

    @JsonSetter
    public void setColor(Integer color){

        colorLista.add(color);
        System.out.println("Lista colora "+ colorLista);
        notifySubscribers("color changed");

    }

    public Element getSelectedElement() {
        return selectedElement;
    }

    public void setSelectedElement(Element selectedElement) {
        this.selectedElement = selectedElement;
    }

    public Integer getColour() {
        return colour;
    }

    public void setColour(Integer colour) {
        this.colour = colour;
    }

    @JsonGetter
    public int getStroke() {
        return stroke;
    }

    @JsonSetter
    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


}
