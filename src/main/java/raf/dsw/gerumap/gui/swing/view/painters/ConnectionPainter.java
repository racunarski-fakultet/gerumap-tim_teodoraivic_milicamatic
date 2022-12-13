package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;

import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;


public class ConnectionPainter extends Painter {

    private Connection connection;
    private Shape shape;

    // ovde se nece crtati nikakav shape vec linija od tacke a do tacke b
    //tako da je draw metoda razlicito implementirana


    public ConnectionPainter(Element element, MapView mapView) {
        super(element, mapView);
        this.connection = (Connection) element;
        this.shape=new Line2D.Float(connection.getX1(),connection.getY1(), connection.getX2(),connection.getY2());

    }

    @Override
    public boolean elementAt( float x, float y) {
        return super.elementAt( x, y);
    }

    @Override
    public void draw(Graphics2D g) {

        g.setPaint(Color.red);
        BasicStroke stroke=new BasicStroke(connection.getStroke());
        g.setStroke(stroke);
        g.draw(shape);

    }
}
