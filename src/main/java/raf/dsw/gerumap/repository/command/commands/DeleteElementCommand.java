package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.Project;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand extends AbstractCommand {

    MapView m;
    Element elementToRemove;
    Painter painterToRemove;
    List<Painter>paintersToRemove;
    List<Element>elementsToRemove;

    List<Painter>copyPainters=new ArrayList<>();

    List<Connection> connectionsFromConcept;
    List<ConnectionPainter> connectionPainterstoRemove;



    public DeleteElementCommand(Element elementToRemove, Painter painterToRemove, List<Connection> connectionsFromConcept, List<ConnectionPainter> connectionPainterstoRemove,MapView m) {
        this.elementToRemove = elementToRemove;
        this.painterToRemove = painterToRemove;
        this.connectionsFromConcept = connectionsFromConcept;
        this.connectionPainterstoRemove = connectionPainterstoRemove;
        this.m=m;

    }

    public DeleteElementCommand(MapView m, List<Painter> paintersToRemove, List<Element> elementsToRemove, List<Connection> connectionsFromConcept, List<ConnectionPainter> connectionPainterstoRemove) {
        this.m = m;
        this.paintersToRemove =new ArrayList<>(paintersToRemove);
        this.elementsToRemove =new ArrayList<>(elementsToRemove);


        this.connectionsFromConcept = connectionsFromConcept;
        this.connectionPainterstoRemove = connectionPainterstoRemove;
        copyPainters=paintersToRemove;
        m.getMindMap().getParent().setChanged(true);
    }

    @Override
    public void doCommand() {

        if (paintersToRemove == null || paintersToRemove.isEmpty()){




            m.getPainters().remove(painterToRemove);
            m.getMindMap().removeElement(elementToRemove);

            if (!connectionsFromConcept.isEmpty()) {
                for (Connection c : connectionsFromConcept) {
                    m.getMindMap().removeElement(c);
                }
            }
            if (!connectionPainterstoRemove.isEmpty()) {
                for (ConnectionPainter cp : connectionPainterstoRemove) {
                    m.getPainters().remove(cp);
                }
            }
        }else {



            for (Painter p : paintersToRemove) {
                m.getPainters().remove(p);
                m.getMindMap().removeElement(p.getElement());
            }

            if (!connectionsFromConcept.isEmpty()) {
                for (Connection c : connectionsFromConcept) {
                    m.getMindMap().removeElement(c);
                }
            }
            if (!connectionPainterstoRemove.isEmpty()) {
                for (ConnectionPainter cp : connectionPainterstoRemove) {
                    m.getPainters().remove(cp);
                }
            }

        }
        m.getMindMap().getParent().setChanged(true);

    }

    @Override
    public void undoCommand() {

        if (paintersToRemove==null || paintersToRemove.isEmpty() ){



            m.getPainters().add(painterToRemove);
            m.getMindMap().addElement(elementToRemove);

            if (!connectionsFromConcept.isEmpty()) {
                for (Connection c : connectionsFromConcept) {
                    m.getMindMap().addElement(c);
                }
            }
            if (!connectionPainterstoRemove.isEmpty()) {
                for (ConnectionPainter cp : connectionPainterstoRemove) {
                    m.getPainters().add(cp);
                }
            }
        }else{


            for (Painter p : paintersToRemove) {
                m.getPainters().add(p);
                m.getMindMap().addElement(p.getElement());

            }


            if (!connectionsFromConcept.isEmpty()) {
                for (Connection c : connectionsFromConcept) {
                    m.getMindMap().addElement(c);
                }
            }
            if (!connectionPainterstoRemove.isEmpty()) {
                for (ConnectionPainter cp : connectionPainterstoRemove) {
                    m.getPainters().add(cp);
                }
            }



        }
        m.getMindMap().getParent().setChanged(true);

    }
}
