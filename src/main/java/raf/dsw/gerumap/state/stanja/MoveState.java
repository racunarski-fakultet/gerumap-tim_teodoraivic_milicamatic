package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.List;

public class MoveState extends State{

    List<Element> selectedElements=new ArrayList<>();
    Element elementToMove=null;
    List<Element>elementsToMove=new ArrayList<>();


    @Override
    public void misKliknut(int x, int y, MapView m) {
        selectedElements = m.getMindMap().getSelectedElements();

      /*  for (Painter p : m.getSelectedPainters()) {
            if (p.elementAt(x, y)) {
                elementToMove=p.getElement();
                break;
            }
        }*/

        if (!elementsToMove.isEmpty()){
            elementsToMove.clear();
        }
        if (elementToMove!=null){
            elementToMove=null;
        }
        if (m.getMindMap().getElements().size()>1){
            for (Element e: m.getMindMap().getSelectedElements()){
                elementsToMove.add(e);
            }
        }else{
            elementToMove=m.getMindMap().getSelectedElements().get(0);

        }


    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {


    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        super.misPusten(x, y, m);
    }
}
