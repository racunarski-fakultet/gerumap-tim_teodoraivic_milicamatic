package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {

    List<MapNode> children = super.getChildren();
    List<Element> elements=new ArrayList<>();

    List<Element> selectedElements = new ArrayList<>();


    public MindMap(String name, MapNode parent) {
        super(name, parent);
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

    public void addElement(Element element){
        System.out.println("usao u addElement"); //udje
        elements.add(element);
        System.out.println(elements +"elementi lista");

        notifySubscribers("dodatt element");

    }

    public void removeElement(Element element){
        elements.remove(element);
        notifySubscribers("obrisan element");
    }
    public void addToSelectedElements(Element element){
       selectedElements.add(element);
    }

    public List<Element> getSelectedElements() {
        return selectedElements;
    }

    public void setSelectedElements(List<Element> selectedElements) {
        this.selectedElements = selectedElements;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
