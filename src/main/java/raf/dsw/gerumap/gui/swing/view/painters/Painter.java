package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;

public class Painter { //pripada viewu


    private Element element;

    private Shape S; //elipsa
    //shape je swingov interface koji pravi oblik


    private MapView mapview;


    public Painter(Element element,MapView mapView) {
        this.element = element;
        this.mapview=mapView;
    }

    public boolean elementAt(float x, float y){

         // return s.contains(x,y);

        //da proveri gde crta
        // jedna linija koda
        //argumenti su x,y
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
