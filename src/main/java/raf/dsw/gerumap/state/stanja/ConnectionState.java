package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConnectionState extends State {

    Connection connection;

    ConnectionPainter painter = null;

    List<Painter> copyPainters = new ArrayList();

    @Override
    public void misKliknut(int x, int y, MapView m) {
       // System.out.println("USO U MIS KLIKNUT ");

        connection = new Connection("veza", m.getMindMap(), m.getMindMap().getDrawColor(),m.getMindMap().getStroke());
        //System.out.println("MISKLIKNUT connection "+connection);
        float x1, y1;
        x1 = x;
        y1 = y;

        if(!copyPainters.isEmpty()){
            copyPainters.clear();
        }

        for (Painter p : m.getPainters()) {
            copyPainters.add(p);

        }
        System.out.println("Copy PAinters" + copyPainters);
        Iterator<Painter> iterator = copyPainters.listIterator();
        while (iterator.hasNext()) {
            Painter iteratorPainter = iterator.next();
            if (!iteratorPainter.elementAt(x, y)) {

                continue;
            } else {

                Concept conceptFrom = (Concept) iteratorPainter.getElement();
                System.out.println("ConceptFrom" + conceptFrom);
                connection.setX1(x);
                connection.setY1(y);


                painter = new ConnectionPainter(connection, m);

                connection.setFromConcept(conceptFrom);

                System.out.println("setovan Concept From" + connection.getFromConcept());

                m.getPainters().add(painter);

                break;
            }
        }

    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {
        //System.out.println("USO U MIS PRITISNUT");

        if (painter == null) {
            //System.out.println("Uso u mispritisnut IF");
            return;
        } else {
            connection.addSubs(painter);
            painter.getConnection().setTo(x, y);
            //System.out.println("USO U MISPRITISNUT ELSE");
           // System.out.println("setovane krajnje iz MISPOVUCEN "+connection.getX2());


        }

    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        boolean potreban=false;

        //System.out.println("USO U MIS PUSTEN "+ painter.getConnection());

         for(Painter p: copyPainters){
             if (p.elementAt(x,y)){
                 potreban=true;
                 Concept toConcept = (Concept) p.getElement();
                 connection.setToConcept(toConcept);
                 System.out.println("SETOVAN TOCONCEPT" + connection.getToConcept());
                 break;
             }
         }

         if (potreban){
             painter.getConnection().setTo(x,y);
             m.getMindMap().addElement(connection);


         }else{
             m.getPainters().remove(painter);
         }

             painter = null;
             connection=null;

    }
}
