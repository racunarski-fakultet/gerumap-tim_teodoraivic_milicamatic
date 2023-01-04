package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.gui.swing.view.painters.SelectionPainter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.RectangleSelection;
import raf.dsw.gerumap.state.State;

import java.awt.*;


public class SelectionState extends State {


    Rectangle rectangle=new Rectangle();
    Point point=new Point();



    @Override
    public void misKliknut(int x, int y, MapView m) {

            if(!m.getMindMap().getSelectedElements().isEmpty()){
                for(Element e : m.getMindMap().getSelectedElements()){
                    e.restorePreviousColor();
                }
                m.getMindMap().getSelectedElements().clear();
                m.getSelectedPainters().clear();
            }


            for (Painter p : m.getPainters()) {
                if (p.elementAt(x, y)) {
                        m.getMindMap().addToSelectedElements(p.getElement());
                        m.getSelectedPainters().add(p);
                         break;
                }
            }
        for (Painter p :m.getPainters())
        {
            if (!p.elementAt(x,y)){
                point.setLocation(x,y);
                rectangle.setLocation(point);
            }
        }

    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {

        rectangle.setSize(x-rectangle.x,y-rectangle.y);
        RectangleSelection rectangleSelection=new RectangleSelection(x,y);
        m.setRectangleSelection(rectangleSelection);
        SelectionPainter selectionPainter=new SelectionPainter(m,rectangle);
        m.setSelectionPainter(selectionPainter);
        rectangleSelection.setCoordinates(x,y);

        for (Painter p : m.getPainters()) {

            if (p.containsShape(rectangle)) {
               if(!m.getMindMap().getSelectedElements().contains(p.getElement())) {
                    m.getMindMap().addToSelectedElements(p.getElement());
                    m.getSelectedPainters().add(p);
               }


            }
        }


    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        if(m.getRectangleSelection() != null){
            m.getRectangleSelection().setCoordinates(x,y);
        }
        m.setSelectionPainter(null);


    }
}
