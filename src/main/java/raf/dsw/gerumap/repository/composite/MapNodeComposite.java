package raf.dsw.gerumap.repository.composite;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property ="type"

)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Project.class, name = "project"),
        @JsonSubTypes.Type(value = MindMap.class, name = "mindmap")
}
)

public abstract class MapNodeComposite extends MapNode {

    List <MapNode> children;

    @JsonProperty
    private String type = "mapnodecomposite";

    public MapNodeComposite(){

    }

    @JsonCreator
    public MapNodeComposite(@JsonProperty("name") String name,@JsonProperty("parent") MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    public MapNodeComposite(String name, MapNode parent, List<MapNode> children) {
        super(name, parent);
        this.children = children;
    }


    @JsonGetter
    public List<MapNode> getChildren() {
        notifySubscribers("children added");

        return children;
    }

    @JsonSetter
    public void setChildren(List<MapNode> children) {
        this.children = children;
    }

    public abstract void addChild(MapNode child);

    public abstract void removeChild(MapNode child);

    public MapNode getChildByName(String name){
        for (MapNode child: this.getChildren()){
            if (name.equals(child.getName())){
                return child;
            }
        }
        return null;
    }



}


