package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;

import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;


public class ConnectionPainter extends Painter {

    private Connection connection;
    //private Shape shape;
    // ovde se nece crtati nikakav shape vec linija od tacke a do tacke b
    //tako da je draw metoda razlicito implementirana


    public ConnectionPainter(Element element, Connection connection, MapView mapView) {
        super(element, mapView);
        this.connection = connection;

    }

    @Override
    public boolean elementAt( float x, float y) {
        return super.elementAt( x, y);
    }

    @Override
    public void draw(Graphics2D g) {

        super.draw(g);
    }
}
