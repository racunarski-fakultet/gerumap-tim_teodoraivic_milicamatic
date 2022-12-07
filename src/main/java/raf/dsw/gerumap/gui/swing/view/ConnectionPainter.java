package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;

public class ConnectionPainter extends Painter{

    private Connection connection;

    public ConnectionPainter(Element element, Connection connection) {
        super(element);
        this.connection = connection;
    }

    @Override
    public void elementAt() {
        super.elementAt();
    }

    @Override
    public void draw(Graphics2D g, Element element) {
        super.draw(g, element);
    }
}
