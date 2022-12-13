package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;

import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


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

       return shape.contains(x,y);
    }
    protected Point2D center(Rectangle2D bounds) {
        return new Point2D.Double(bounds.getCenterX(), bounds.getCenterY());
    }
    protected double angleBetween(Shape from, Shape to) {
        return angleBetween((Shape) center(from.getBounds2D()), (Shape) center(to.getBounds2D()));
    }
    //
    protected double angleBetween(Point2D from, Point2D to) {
        double x = from.getX();
        double y = from.getY();

        // This is the difference between the anchor point
        // and the mouse.  Its important that this is done
        // within the local coordinate space of the component,
        // this means either the MouseMotionListener needs to
        // be registered to the component itself (preferably)
        // or the mouse coordinates need to be converted into
        // local coordinate space
        double deltaX = to.getX() - x;
        double deltaY = to.getY() - y;

        // Calculate the angle...
        // This is our "0" or start angle..
        double rotation = -Math.atan2(deltaX, deltaY);
        rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

        return rotation;
    }
    protected Point2D getPointOnCircle(Shape shape, double radians) {
        Rectangle2D bounds = shape.getBounds();
//          Point2D point = new Point2D.Double(bounds.getX(), bounds.getY());
        Point2D point = center(bounds);
        return getPointOnCircle(point, radians, Math.max(bounds.getWidth(), bounds.getHeight()) / 2d);
    }

    protected Point2D getPointOnCircle(Point2D center, double radians, double radius) {

        double x = center.getX();
        double y = center.getY();

        radians = radians - Math.toRadians(90.0); // 0 becomes th?e top
        // Calculate the outter point of the line
        double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
        double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

        return new Point2D.Double(xPosy, yPosy);

    }

    @Override
    public void draw(Graphics2D g) {
//        Point2D elipsa1 = new Point2D.Float(connection.getFrom().getX(),connection.getFrom().getY());
//        Point2D elipsa2 = new Point2D.Float(connection.getTo().getX(),connection.getTo().getY());
//
//        g.setPaint(Color.red);
//        BasicStroke stroke=new BasicStroke(connection.getStroke());
//        double from = angleBetween(elipsa1, elipsa2);// shapeovi
//        double to = angleBetween(elipsa1, elipsa2);
//
//        Point2D pointFrom = getPointOnCircle(elipsa1, from);
//        Point2D pointTo = getPointOnCircle(elipsa2, to);
//        g.setStroke(stroke);
//        g.draw(shape);

    }
}
