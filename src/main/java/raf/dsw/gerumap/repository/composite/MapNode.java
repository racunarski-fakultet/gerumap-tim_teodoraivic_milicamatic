package raf.dsw.gerumap.repository.composite;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.implementation.Element;

import java.util.ArrayList;
import java.util.List;

//@JsonTypeInfo(use = Element.class,
  //      include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class MapNode implements IPublisher { //ne moze da ima decu

    private String name;

    @JsonIgnore
    private transient MapNode parent; //transient kada ne treba serijalizer da ga pamti
    @JsonIgnore
    private transient List<ISubscriber> subscribers = new ArrayList<>();

    public MapNode(){

    }

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        //subscribers = new ArrayList<>();
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
        notifySubscribers("name changed");
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode){
            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }


    @Override
    public void notifySubscribers(Object notification) {
        for(ISubscriber sub : subscribers){
            sub.update(notification);
        }
    }

    @Override
    public void addSubs(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        subscribers.remove(sub);
    }
}
