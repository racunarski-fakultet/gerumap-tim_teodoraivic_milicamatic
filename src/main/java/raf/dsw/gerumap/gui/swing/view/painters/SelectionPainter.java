package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.*;

public class SelectionPainter extends Painter{

    Shape s;


    public SelectionPainter(MapView mapView,Rectangle rectangle){
        super(mapView);
        s=rectangle;

    }

    @Override
    public boolean elementAt(float x, float y) {

        return super.elementAt(x, y);
    }



    @Override
    public void draw(Graphics2D g) {
        System.out.println("usao u draw selPainter");

        BasicStroke basicStroke=new BasicStroke(1);
        g.setStroke(basicStroke);
        g.setPaint(Color.blue);
        g.draw(s);
    }
}
