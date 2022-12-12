package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {

    List<MapNode> children = super.getChildren();
    List<Element> elements=new ArrayList<>();

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

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
