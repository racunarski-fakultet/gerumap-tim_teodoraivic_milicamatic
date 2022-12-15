package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;

public class Painter {


    private Element element;

    private Shape S;

    Color color;


    private MapView mapview;


    public Painter(Element element,MapView mapView) {
        this.element = element;
        this.mapview=mapView;
        this.color = Color.black;
    }

    public boolean elementAt(float x, float y){
        return true;
      }

    public void draw(Graphics2D g ){

    }

    public MapView getMapview() {
        return mapview;
    }

    public void setMapview(MapView mapview) {
        this.mapview = mapview;
    }
}
