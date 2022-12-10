package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;

public class Painter { //pripada viewu


    private Element element;

    private Shape S; //elipsa
    //shape je swingov interface koji pravi oblik


    public Painter(Element element,Shape s) {
        this.element = element;
        this.S=s;
    }

    public void elementAt(float x, float y){

          S.contains(x,y);

        //da proveri gde crta
        // jedna linija koda
        //argumenti su x,y
      }

    public void draw(Graphics2D g ){

    }



}
