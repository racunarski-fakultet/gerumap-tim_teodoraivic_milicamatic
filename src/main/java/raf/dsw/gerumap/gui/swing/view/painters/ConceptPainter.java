package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConceptPainter extends Painter {

    private Concept concept;



    public ConceptPainter(Element element) {
        super(element);
    }

    @Override
    public void elementAt() {
        super.elementAt();
    }

    @Override
    public void draw(Graphics2D g, Element element) {
        // crta se elipsa
        //g.draw(shape);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke=new BasicStroke(10);
        g2.setStroke(stroke);
        Ellipse2D.Float ln=new
                Ellipse2D.Float(concept.getX(),concept.getY(),concept.getWidth(),concept.getHeight());
        g2.draw(ln);


    }
}
