package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Element extends MapNode {

    private Paint colour;
    private List<Paint>colorLista;
    private int stroke=1;

    private Element selectedElement = null;



    public Element(String name, MapNode parent) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        colorLista.add(Color.BLACK);


    }

    public Element(String name, MapNode parent,Paint color) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        this.colorLista.add(color);

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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
