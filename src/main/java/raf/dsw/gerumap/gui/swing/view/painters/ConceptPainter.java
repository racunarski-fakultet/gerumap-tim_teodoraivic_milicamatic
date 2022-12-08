package raf.dsw.gerumap.gui.swing.view.painters;

import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;

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
    }
}
