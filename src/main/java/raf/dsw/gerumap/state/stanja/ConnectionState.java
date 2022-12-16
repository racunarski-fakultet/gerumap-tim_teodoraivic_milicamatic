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

        connection = new Connection("veza", m.getMindMap());
        //System.out.println("MISKLIKNUT connection "+connection);
        float x1, y1;
        x1 = x;
        y1 = y;

        for (Painter p : m.getPainters()) {
            copyPainters.add(p);

        }
        Iterator<Painter> iterator = copyPainters.listIterator();
        while (iterator.hasNext()) {
            if (!iterator.next().elementAt(x, y)) {

                continue;
            } else {
                connection.setX1(x);
                connection.setY1(y);
                connection.setFromConcept((Concept) iterator.next().getElement());
                //System.out.println("setovan Concept From" + connection.getFromConcept());
                painter = new ConnectionPainter(connection, m);
                //System.out.println("setovane pocetne"+x + " " + y);
                m.getPainters().add(painter);
                //System.out.println("Lista paintera MIS KLIKNUT" + m.getPainters());
                break;
            }
        }
        //System.out.println("Dobio pocetne kord iz miskliknut "+connection.getX1());
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
       // System.out.println("painters iz mispusten:" +m.getPainters());
             painter = null;
             connection=null;

    }
}
