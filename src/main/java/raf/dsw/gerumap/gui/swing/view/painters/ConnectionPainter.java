package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ConnectionPainter extends Painter {

    private Connection connection;
    private Shape shape;


    public ConnectionPainter(Element element, Shape s, Connection connection) {
        super(element, s);
        this.connection = connection;

    }



    @Override
    public void elementAt(float x, float y) {
        super.elementAt(x, y);
    }

    @Override
    public void draw(Graphics2D g) {

        super.draw(g);
    }
}
