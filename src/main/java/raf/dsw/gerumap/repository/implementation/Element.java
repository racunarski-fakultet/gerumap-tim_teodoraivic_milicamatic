package raf.dsw.gerumap.repository.implementation;

import com.fasterxml.jackson.annotation.*;
import raf.dsw.gerumap.repository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property ="type"

)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Concept.class, name = "concept"),
        @JsonSubTypes.Type(value = Connection.class, name = "connection")
}
)

public abstract class Element extends MapNode {


    private int colour=0x000000;
    @JsonIgnore
    transient private List<Integer>colorLista;


    private int stroke=1;
    @JsonIgnore
     private transient Element selectedElement = null;

    @JsonProperty
    private String type = "element";

    public Element() {
        super(null,null);
    }

//    @JsonCreator
    public Element( String name, MapNode parent) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        colorLista.add(0x000000);

    }

    public Element( String name, MapNode parent
            , Integer color,int stroke) {

        super(name, parent);
        this.colorLista=new ArrayList<>();
        this.colorLista.add(color);
        this.stroke = stroke;

    }


    @JsonIgnore
    public Integer getCurrentColor(){

        return colorLista.get(colorLista.size()-1);
    }


    public void restorePreviousColor(){
        //pretposlednji postaje poslednji
         colorLista.remove(colorLista.size()-1);
        notifySubscribers("color changed");

    }

    //@JsonSetter
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

   // @JsonGetter
    public Integer getColour() {
        return colour;
    }

   // @JsonSetter
    public void setColour(Integer colour) {
        this.colour = colour;
    }

    //@JsonGetter
    public int getStroke() {
        return stroke;
    }

    ////@JsonSetter
    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


}
