package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConceptPainter extends Painter {

    private Concept concept;
    //na osnovu ovog modela cu da nacrtam shape u draw metodi
    private Shape shape;


    public ConceptPainter(Element element,MapView mapView) {
        super(element,mapView);

        concept=(Concept)element;

        this.shape=new Ellipse2D.Float(concept.getX(),concept.getY(), concept.getWidth(), concept.getHeight());
    }

    @Override
    public boolean elementAt( float x, float y) {
        return super.elementAt( x, y);
    }

    @Override
    public void draw(Graphics2D g) {

        g.setPaint(Color.black);
        BasicStroke stroke=new BasicStroke(concept.getStroke());
        g.setStroke(stroke);
        g.draw(shape);

        Font f=new Font(concept.getName(),Font.PLAIN,10);

        g.setFont(f);

        g.drawString(concept.getName(),concept.getX()+20,concept.getY()+20);

    }



    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
