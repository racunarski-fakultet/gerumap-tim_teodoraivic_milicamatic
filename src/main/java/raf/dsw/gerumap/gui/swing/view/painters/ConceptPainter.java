package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConceptPainter extends Painter {

    private Concept concept;
    private Shape shape;

    private Color color;


    public ConceptPainter(Element element,MapView mapView) {
        super(element,mapView);

        concept=(Concept)element;

        System.out.println("Ime koncepta:");
        System.out.println(concept.getName());

        this.shape=new Ellipse2D.Float(concept.getX(),concept.getY(), concept.getWidth(), concept.getHeight());
        this.color = Color.black;
    }

    @Override
    public boolean elementAt( float x, float y) {
        return shape.contains(x,y);
    }

    @Override
    public void draw(Graphics2D g) {

        g.setPaint(concept.getCurrentColor());

        BasicStroke stroke=new BasicStroke(concept.getStroke());
        g.setStroke(stroke);
        g.draw(shape);

        Font f=new Font(concept.getName(),Font.PLAIN,10);

        g.setFont(f);

        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(concept.getName());
        int offset = (int) ((concept.getWidth() - width ) / 2);
        g.drawString(concept.getName(), concept.getX() + offset, concept.getY()+ (concept.getWidth()/4)+5);

       // g.drawString(concept.getName(),concept.getX()+20,concept.getY()+20);

    }
    public boolean containsShape(Rectangle rectangle){

        return shape.intersects(rectangle);

    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
