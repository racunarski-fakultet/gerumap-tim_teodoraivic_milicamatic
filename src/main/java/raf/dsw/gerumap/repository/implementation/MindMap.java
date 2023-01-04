package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.awt.*;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {

    @JsonProperty
    List<Element> elements;

    Integer drawColor = 0x000000;

    @JsonProperty
    private String type = "mindmap";

    @JsonIgnore
    Color color = new Color(drawColor);
    @JsonIgnore
    transient List<Element> selectedElements = new ArrayList<>();
    @JsonIgnore
    transient List<Integer>strokeList=new ArrayList<>();

    int stroke = 1;

    public MindMap() {
        super(null,null);
    }

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        strokeList.add(stroke);
        elements=new ArrayList<>();
    }

    @JsonCreator
    public MindMap(@JsonProperty("name") String name,@JsonProperty("parent") MapNode parent,
                   @JsonProperty("elements") List<Element>elements) {
        super(name, parent);
        strokeList.add(stroke);
        this.elements=elements;

    }

    @Override
    public void addChild(MapNode child) {
        if ( child!=null && child instanceof Element){
            Element element=(Element) child;
            if (!this.getChildren().contains(element)){
                this.getChildren().add(element);
                notifySubscribers("mindmap added");
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child!=null && child instanceof Element){
            Element element = (Element) child;
            boolean contains=getChildren().contains(element);
            if (contains){
                this.getChildren().remove(element);
                notifySubscribers("mindmap removed");
            }
        }
    }
    public void repaintMapview(){
        notifySubscribers("repaint");
    }

    @JsonIgnore
    public void addElement(Element element){
        elements.add(element);
        if(this.getParent() != null)
        {this.getParent().setChanged(true);}

        notifySubscribers("dodatt element");

    }
    @JsonIgnore
    public void removeElement(Element element){
        elements.remove(element);
        this.getParent().setChanged(true);
        notifySubscribers("obrisan element");
    }
    public void addToSelectedElements(Element element){
        element.setColor(0x0000FF);
        selectedElements.add(element);
    }

    public Integer getDrawColor() {
        return drawColor;
    }

    public void initialStroke(int stroke){

        this.stroke = stroke;
        strokeList.add(stroke);
    }

    @JsonIgnore
    public void setNewStroke(int stroke){

        strokeList.add(stroke);
        for(Element e: elements){
            this.getParent().setChanged(true);

            e.setStroke(stroke);
            //e.setStroke(strokeList.get(strokeList.size()-1));
        }
    }
    public void setSelectedStroke(int stroke){

        strokeList.add(stroke);
        for(Element e: selectedElements){
            e.setStroke(stroke);
            this.getParent().setChanged(true);

        }
        selectedElements.clear();
    }

    public void restorePreviousStroke(int stroke){
        strokeList.remove(strokeList.size()-1);
    }

    @JsonIgnore
    public void setDrawColor(Integer drawColor) {


        this.drawColor = drawColor;
        this.getParent().setChanged(true);

    }
    @JsonIgnore
    public void recolorSelection(Integer color){

        System.out.println("Lista selektovanih elem" + selectedElements);
        for(Element e: selectedElements){

            this.getParent().setChanged(true);

            e.setColour(color);
        }
       // selectedElements.clear();
    }
    @JsonIgnore
    public void recolorElement(Integer color){
        for(Element e: elements){
            //this.getParent().setChanged(true);
            e.setColor(color);
        }
    }

    public List<Element> getSelectedElements() {
        return selectedElements;
    }

    public void setSelectedElements(List<Element> selectedElements) {
        this.selectedElements = selectedElements;
    }

    @JsonGetter
    public List<Element> getElements() {
        return elements;
    }

    @JsonSetter
    public void setElements(List<Element> elements) {
        this.elements = elements;
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
