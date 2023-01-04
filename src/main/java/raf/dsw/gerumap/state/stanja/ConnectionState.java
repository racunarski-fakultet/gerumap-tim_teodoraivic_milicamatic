package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.commands.ConnectionCommand;
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

        connection = new Connection("veza", m.getMindMap(), m.getMindMap().getDrawColor(),m.getMindMap().getStroke());

        if(!copyPainters.isEmpty()){
            copyPainters.clear();
        }

        for (Painter p : m.getPainters()) {
            copyPainters.add(p);

        }
        Iterator<Painter> iterator = copyPainters.listIterator();
        while (iterator.hasNext()) {
            Painter iteratorPainter = iterator.next();
            if (!iteratorPainter.elementAt(x, y)) {

                continue;
            } else {

                Concept conceptFrom = (Concept) iteratorPainter.getElement();
                connection.setX1(x);
                connection.setY1(y);


                painter = new ConnectionPainter(connection, m);
                connection.setFromConcept(conceptFrom);


                break;
            }
        }

    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {

        if (painter == null) {
            return;
       } else {

            connection.setTo(x,y);
            m.setConnection(connection);
            painter.changeCoordinates(x,y);
            m.setConnectionPainter(painter);
            connection.trigger();
            m.getPainters().add(painter);


        }
    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        boolean potreban=false;

        Iterator<Painter>iteratorr=m.getPainters().iterator();
        while(iteratorr.hasNext()){
            Painter p=iteratorr.next();
            if (p.equals(painter)){
                iteratorr.remove();
            }

        }


         for(Painter p: copyPainters){
             if (p.elementAt(x,y)){
                 potreban=true;
                 Concept toConcept = (Concept) p.getElement();
                 connection.setToConcept(toConcept);
                 break;
             }
         }

         if (potreban){

             connection.setTo(x,y);
             painter.changeCoordinates(x,y);


             AbstractCommand command=new ConnectionCommand(connection,painter,m,x,y);
             AppCore.getInstance().getGui().getCommandManager().addCommand(command);


         }else{
             m.getPainters().remove(painter);
         }

             painter = null;
             connection=null;
    }

}
