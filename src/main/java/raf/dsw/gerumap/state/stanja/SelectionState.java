package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.gui.swing.view.painters.SelectionPainter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.RectangleSelection;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SelectionState extends State {


    Rectangle rectangle=new Rectangle();
    Point point=new Point();
    List<Painter>rectPainteri=new ArrayList<>();
    SelectionPainter selectionPainter;




    List<Element> selectedElements;

    //mouse pressed zapravo
    @Override
    public void misKliknut(int x, int y, MapView m) {

        selectedElements = m.getMindMap().getSelectedElements();


            if(!selectedElements.isEmpty()){
                for(Element e : selectedElements){
                    e.restorePreviousColor();
                }
                selectedElements.clear();
            }


            for (Painter p : m.getPainters()) {
                if (p.elementAt(x, y)) {

                        p.getElement().setColor(Color.BLUE);
                        selectedElements.add(p.getElement());
                         break;

                }
            }
        for (Painter p :m.getPainters())
        {

            if (!p.elementAt(x,y)){
                point.setLocation(x,y);
                rectangle.setLocation(point);
                //System.out.println("USO U MISKLIKNUT I SETOVAO POINT "+point.getX());
            }
        }

    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {


        rectangle.setSize(x-rectangle.x,y-rectangle.y);
//        System.out.println("USO U MISDRAGGED,pritisnut, set size: "+rectangle.height);

        RectangleSelection rectangleSelection=new RectangleSelection(x,y);
        m.setRectangleSelection(rectangleSelection);

        SelectionPainter selectionPainter=new SelectionPainter(m,rectangle);
        m.setSelectionPainter(selectionPainter);

        //System.out.println("napravio rectSelection i selPainter: "+rectangleSelection+selectionPainter);
        rectangleSelection.setCoordinates(x,y);

       selectedElements = m.getMindMap().getSelectedElements();


        for (Painter p : m.getPainters()) {


            if (p.containsShape(rectangle)) {
               // System.out.println("iz contains shape: "+p.containsShape(rectangle)+ rectangle);

                p.getElement().setColor(Color.BLUE);
                selectedElements.add(p.getElement());


            }
        }



    }

    @Override
    public void misPusten(int x, int y, MapView m) {

        m.getRectangleSelection().setCoordinates(0,0);
        m.setSelectionPainter(null);
        m.setRectangleSelection(null);



//                if(!selectedElements.isEmpty()){
//            for(Element e : selectedElements){
//                e.restorePreviousColor();
//            }
//            //selectedElements.clear();
//        }


    }
}
