package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.State;

import java.awt.*;


public class SelectionState extends State {

    //selElements

    Element selElement=null;

    @Override
    public void misKliknut(int x, int y, MapView m) {

            if (selElement!=null){
                selElement.restorePreviousColor();
                selElement=null;
            }

            for (Painter p : m.getPainters()) {

                if (p.elementAt(x, y)) {
                    selElement=p.getElement();
                    selElement.setColor(Color.BLUE);
                    System.out.println(selElement.getCurrentColor());
                    break;

                }
            }

    }
}
