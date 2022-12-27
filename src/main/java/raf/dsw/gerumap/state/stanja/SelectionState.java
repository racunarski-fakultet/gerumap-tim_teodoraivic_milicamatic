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

       // selectedElements = m.getMindMap().getSelectedElements();
        //addtoselectedelements

            if(!m.getMindMap().getSelectedElements().isEmpty()){
                for(Element e : m.getMindMap().getSelectedElements()){
                    e.restorePreviousColor();

                }
                m.getMindMap().getSelectedElements().clear();
                m.getSelectedPainters().clear();
            }


            for (Painter p : m.getPainters()) {
                if (p.elementAt(x, y)) {

                       // p.getElement().setColor(Color.BLUE);
                       // selectedElements.add(p.getElement());
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

       //selectedElements = m.getMindMap().getSelectedElements();


        for (Painter p : m.getPainters()) {


            if (p.containsShape(rectangle)) {
               // System.out.println("iz contains shape: "+p.containsShape(rectangle)+ rectangle);
               // List<Element> listaSelektovanih = m.getMindMap().getSelectedElements();
               if(!m.getMindMap().getSelectedElements().contains(p.getElement())) {
                    m.getMindMap().addToSelectedElements(p.getElement());
                    m.getSelectedPainters().add(p);
               }
               // System.out.println("Equals" + m.getMindMap().getSelectedElements().contains(p.getElement()));
                System.out.println("Lista selektovanih" + m.getMindMap().getSelectedElements());



            }
        }



    }

    @Override
    public void misPusten(int x, int y, MapView m) {
      // RectangleSelection rectangleSelection=new RectangleSelection(x,y);
        System.out.println("RectangleSelection" + m.getRectangleSelection());
        if(m.getRectangleSelection() != null){
            m.getRectangleSelection().setCoordinates(x,y);
        }
        m.setSelectionPainter(null);
        //m.setRectangleSelection(null);



    }
}
