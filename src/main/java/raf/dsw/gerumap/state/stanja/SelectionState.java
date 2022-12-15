package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectionState extends State {

    List<Painter> selectedPainters = new ArrayList<>();

    Painter selectedPainter = null;
    boolean isSelected = false;

    @Override
    public void misKliknut(int x, int y, MapView m) {

        if(selectedPainter == null) {
            for (Painter p : m.getPainters()) {
                System.out.println(p.elementAt(x, y) + "element at ");
                if (p.elementAt(x, y)) {
                    System.out.println("USO U IF U SELECTED");
                    isSelected = true;
                    if (p instanceof ConnectionPainter) {
                        ((ConnectionPainter) p).setColor(Color.BLUE);
                        m.getMindMap().setSelectedElement(((ConnectionPainter) p).getConnection());
                        selectedPainter = p;

                    } else if (p instanceof ConceptPainter) {
                        ((ConceptPainter) p).setColor(Color.BLUE);
                        m.getMindMap().setSelectedElement(((ConceptPainter) p).getConcept());
                        selectedPainter = p;
                        break;
                    }

                }
            }
             }
        for (Painter p : m.getPainters()) {

            if (!p.elementAt(x, y)) {
                if (p instanceof ConnectionPainter) {
                    ((ConnectionPainter) p).setColor(Color.BLACK);
                }else if (p instanceof ConceptPainter) {
                    ((ConceptPainter) p).setColor(Color.BLACK);
                }
                selectedPainter = null;
            }
        }






    }
}
