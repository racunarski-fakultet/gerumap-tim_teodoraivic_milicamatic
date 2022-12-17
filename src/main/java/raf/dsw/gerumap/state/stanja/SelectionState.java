package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.List;


public class SelectionState extends State {



    List<Element> selectedElements;

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


    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {

    }
}
