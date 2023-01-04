package raf.dsw.gerumap.repository.composite;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.implementation.Element;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property ="type"

)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MapNodeComposite.class, name = "mapnodecomposite"),
        @JsonSubTypes.Type(value = Element.class, name = "element")
}
)
public abstract class MapNode implements IPublisher {

    private String name;

    @JsonIgnore
    private transient MapNode parent;
    @JsonIgnore
    private transient List<ISubscriber> subscribers = new ArrayList<>();

    public MapNode(){

    }


    @JsonCreator
    public MapNode(@JsonProperty("name") String name, @JsonProperty("parent") MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    //@JsonGetter
    public String getName() {
        return name;
    }

   // @JsonSetter
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
