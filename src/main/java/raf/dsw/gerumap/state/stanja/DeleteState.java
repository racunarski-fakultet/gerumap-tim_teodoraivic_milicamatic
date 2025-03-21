package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.commands.DeleteElementCommand;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {

    boolean elementFound = false;
    Element elementToRemove;
    Painter painterToRemove;
    Concept toConcept;
    Concept fromConcept;
    List<Connection> connectionsFromConcept = new ArrayList<>();
    List<ConnectionPainter> connectionPainterstoRemove = new ArrayList<>();
    List<Element> selectedElements;

    @Override
    public void misKliknut(int x, int y, MapView m) {

        selectedElements = m.getMindMap().getSelectedElements();

        if (selectedElements.isEmpty()) {

            for (Painter p : m.getPainters()) {
                if (p.elementAt(x, y)) {
                    elementFound = true;
                    painterToRemove = p;
                    elementToRemove = p.getElement();
                    break;
                }
            }

            for (Painter p : m.getPainters()) {

                if (p.getElement() instanceof Connection) {
                    toConcept = ((Connection) p.getElement()).getToConcept();
                    fromConcept = ((Connection) p.getElement()).getFromConcept();
                }
                if (p.getElement() instanceof Connection && elementToRemove instanceof Concept) {
                    System.out.println(fromConcept);
                    System.out.println(toConcept);
                    System.out.println(elementToRemove);

                    if (toConcept.equals(elementToRemove)) {
                        connectionsFromConcept.add((Connection) p.getElement());
                        connectionPainterstoRemove.add((ConnectionPainter) p);
                    } else if (fromConcept.equals(elementToRemove)) {
                        connectionsFromConcept.add((Connection) p.getElement());
                        connectionPainterstoRemove.add((ConnectionPainter) p);
                    }

                }
            }


            if (elementFound) {

                AbstractCommand command=new DeleteElementCommand(elementToRemove,painterToRemove,connectionsFromConcept,connectionPainterstoRemove,m);
                AppCore.getInstance().getGui().getCommandManager().addCommand(command);

                connectionsFromConcept.clear();
                connectionPainterstoRemove.clear();

                elementToRemove = null;
                elementFound = false;

            }
        } else {

            for (Painter p : m.getSelectedPainters()) {

                if(p.getElement() instanceof Concept) {
                    painterToRemove = p;
                    elementToRemove = p.getElement();
                }

                for (Painter pp : m.getPainters()) {
                    if (pp.getElement() instanceof Connection) {
                        toConcept = ((Connection) pp.getElement()).getToConcept();
                        fromConcept = ((Connection) pp.getElement()).getFromConcept();

                        if (toConcept.equals(elementToRemove)) {
                            connectionsFromConcept.add((Connection) pp.getElement());
                            connectionPainterstoRemove.add((ConnectionPainter) pp);
                        } else if (fromConcept.equals(elementToRemove)) {
                            connectionsFromConcept.add((Connection) pp.getElement());
                            connectionPainterstoRemove.add((ConnectionPainter) pp);
                        }
                    }
                }
            }
            AbstractCommand command=new DeleteElementCommand(m,m.getSelectedPainters(),m.getMindMap().getSelectedElements(),connectionsFromConcept,connectionPainterstoRemove);
            AppCore.getInstance().getGui().getCommandManager().addCommand(command);




            connectionsFromConcept.clear();
            connectionPainterstoRemove.clear();


                for(Element e : m.getMindMap().getSelectedElements()){
                    e.restorePreviousColor();
                }
                m.getMindMap().getSelectedElements().clear();
                m.getSelectedPainters().clear();


        }




    }
}
