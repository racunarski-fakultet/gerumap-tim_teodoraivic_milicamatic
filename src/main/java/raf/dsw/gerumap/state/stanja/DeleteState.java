package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {
   //treba da selektovani element izbrise sa mapviewa
    // uzimamo selected uklanjamo iz liste elemenata i zovemo repaint nekako
    //ako se brise elipsa brisu se veze koje izlaze iz nje
    // ako je selected concept vidi da
    // to from u connectionu, prodejm kroz listu connectina get.to i getfrom i ako se poklapa sa elipsom ukloni
   // treba da elementu damo selected
    boolean elementFound = false;
    Element elementToRemove;

    Painter painterToRemove;

    Concept toConcept;
    Concept fromConcept;

    List<Connection> connectionsFromConcept = new ArrayList<>();
    List<ConnectionPainter> connectionPainterstoRemove = new ArrayList<>();

    @Override
    public void misKliknut(int x, int y, MapView m) {
        //prodjemo kroz listu paintera
        //ako smo uboli neki ukloni ga iz liste elementa (removeElements metoda + notify za repaint)
        //i ukloni ga iz liste paintera

        for (Painter p : m.getPainters()) {
            if (p.elementAt(x, y)) {
                elementFound = true;
                painterToRemove = p;
                elementToRemove = p.getElement();
                break;
            }
        }


        for (Painter p : m.getPainters()) {

            if(p.getElement() instanceof Connection) {
                toConcept = ((Connection) p.getElement()).getToConcept();
                fromConcept = ((Connection) p.getElement()).getFromConcept();
            }
            if (p.getElement() instanceof Connection && elementToRemove instanceof Concept) {
                //da li je to i from tom connectionu isti kao nas element found
                System.out.println("Test equalsa" + toConcept.equals(elementToRemove));
                //mora da se popravi equals
                if (toConcept.equals(elementToRemove)) {
                    //ako je to concept connectiona jednak element to remove brise se i element to remove
                    connectionsFromConcept.add((Connection) p.getElement());
                    connectionPainterstoRemove.add((ConnectionPainter) p);
                } else if (fromConcept.equals(elementToRemove)){
                    connectionsFromConcept.add((Connection) p.getElement());
                    connectionPainterstoRemove.add((ConnectionPainter) p);
                }

            }
        }


        if (elementFound) {

            m.getPainters().remove(painterToRemove);
            m.getMindMap().removeElement(elementToRemove);

            if(!connectionsFromConcept.isEmpty()){
            for(Connection c : connectionsFromConcept){
                m.getMindMap().removeElement(c);
            }
            connectionsFromConcept.clear();
            }
            if(!connectionPainterstoRemove.isEmpty()){
                for(ConnectionPainter cp: connectionPainterstoRemove){
                    m.getPainters().remove(cp);
                }
                connectionPainterstoRemove.clear();
            }


            elementToRemove = null;
            elementFound = false;



        }

    }



}
