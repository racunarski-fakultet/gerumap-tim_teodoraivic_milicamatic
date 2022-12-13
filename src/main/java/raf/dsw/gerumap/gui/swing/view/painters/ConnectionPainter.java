package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.MapView;

import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;



public class ConnectionPainter extends Painter implements ISubscriber {

    private Connection connection;
    private Shape shape;

    private ConceptPainter from;

    private ConceptPainter to;

    // ovde se nece crtati nikakav shape vec linija od tacke a do tacke b
    //tako da je draw metoda razlicito implementirana


    public ConnectionPainter(Element element, MapView mapView) {
        super(element, mapView);

        this.connection = (Connection) element;
       // this.connection.addSubs(this);
        this.shape=new Line2D.Float(connection.getX1(),connection.getY1(), connection.getX2(),connection.getY2());

    }

    @Override
    public boolean elementAt( float x, float y) {

       return shape.contains(x,y);
    }


    @Override
    public void draw(Graphics2D g) {
        System.out.println("usao u draw connectiona");
      g.setPaint(Color.red);
      BasicStroke stroke=new BasicStroke(connection.getStroke());


       g.setStroke(stroke);
       g.draw(shape);

    }

    public ConceptPainter getFrom() {
        return from;
    }

    public void setFrom(ConceptPainter from) {
        this.from = from;
    }

    public ConceptPainter getTo() {
        return to;
    }

    public void setTo(ConceptPainter to) {
        this.to = to;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void update(Object notification) {

        setShape(new Line2D.Float(connection.getX1(),connection.getY1(), connection.getX2(),connection.getY2()));
    }
}
