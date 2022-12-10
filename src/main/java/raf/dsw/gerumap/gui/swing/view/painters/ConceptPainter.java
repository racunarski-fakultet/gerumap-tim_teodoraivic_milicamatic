package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConceptPainter extends Painter {

    private Concept concept;
    //na osnovu ovog modela cu da nacrtam shape u draw metodi
    private Shape shape;


    public ConceptPainter(Element element, Shape s, Concept concept) {
        super(element, s);

        this.shape=new Ellipse2D.Float(concept.getX(),concept.getY(),concept.getWidth(),concept.getHeight());
    }

    @Override
    public void elementAt(float x, float y) {
        super.elementAt(x, y);
    }

    @Override
    public void draw(Graphics2D g) {


        Graphics2D g2 = (Graphics2D) g;
        Font f=new Font(concept.getName(),Font.PLAIN,10);
        BasicStroke stroke=new BasicStroke(concept.getStroke());
        g2.setStroke(stroke);
        g2.setColor(Color.CYAN);
        g2.setFont(f);

        g2.draw(shape);
        //g2.drawString(concept.getName(),concept.getX()+5,concept.getY()+5);


    }
}
