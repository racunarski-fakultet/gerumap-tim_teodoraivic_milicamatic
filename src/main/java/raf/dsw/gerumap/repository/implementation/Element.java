package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Element extends MapNode {

    private Paint colour;
    transient private List<Paint>colorLista;
    private int stroke;

     private transient Element selectedElement = null;



    public Element(String name, MapNode parent) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        colorLista.add(Color.BLACK);


    }

    public Element(String name, MapNode parent,Paint color,int stroke) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        this.colorLista.add(color);
        this.stroke = stroke;

    }

    public Paint getCurrentColor(){
        return colorLista.get(colorLista.size()-1);
    }

    public void restorePreviousColor(){
        //pretposlednji postaje poslednji
         colorLista.remove(colorLista.size()-1);
        notifySubscribers("color changed");

    }
    public void setColor(Paint color){
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = colour != null ? colour.hashCode() : 0;
        result = 31 * result + (colorLista != null ? colorLista.hashCode() : 0);
        result = 31 * result + stroke;
        return result;
    }
}
