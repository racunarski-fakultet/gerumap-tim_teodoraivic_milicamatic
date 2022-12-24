package raf.dsw.gerumap.repository.composite;

import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNode implements IPublisher { //ne moze da ima decu

    private String name = " ";

    private transient MapNode parent; //transient kada ne treba serijalizer da ga pamti

    private List<ISubscriber> subscribers;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

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
