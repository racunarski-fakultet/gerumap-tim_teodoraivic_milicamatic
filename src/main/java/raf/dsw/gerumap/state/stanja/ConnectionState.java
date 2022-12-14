package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.state.State;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionState extends State {

    Connection connection;

    ConnectionPainter painter = null;

    @Override
    public void misKliknut(int x, int y, MapView m) {
        System.out.println("Mis kliknut iz connectionstatea");
       // super.misKliknut(x, y, m);
        //da li mv.painters contains x,y
        //if not return
        //ako neki od njih containuje
        //else veza painter = veza painter pocetna koord
        //mv.addPainter
        //mispovucen x,y,mv ukoliko je painter null ispadamo
        //ako nije null
        connection=new Connection("veza", m.getMindMap());
        float x1,y1;
        x1=x;
        y1=y;

        List copyPainters = new CopyOnWriteArrayList(m.getPainters());
        Iterator<Painter> iterator = copyPainters.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().elementAt(x,y)){
                //ConceptPainter cp = (ConceptPainter) p;
                //connection.setFrom(cp.getConcept());
                return;
            }else{
                connection.setX1(x);
                connection.setY1(y);
                painter = new ConnectionPainter(connection,m);
                painter.setFrom((ConceptPainter) iterator.next());
                System.out.println("setovane pocetne");
                m.getPainters().add(painter);
                System.out.println("Lista paintera" + m.getPainters());
                System.out.println(x + " " + y);
            }
        }
    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {
        //treba da dobijemo concept od kog krecemo
        //
        // super.misPritisnut(x, y, m);
       // ConnectionPainter painter = null;


        //u ovoj metodi samo dodeljujem pocetne koordinate

            if(painter == null){
                return;
            }else{
                connection.addSubs(painter);
               // painter.setTo((ConceptPainter) p);
                System.out.println("setovane krajnje");
                painter.getConnection().setTo(x,y);

            }

    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        //super.misPusten(x, y, m);



        //Painter painter=new ConnectionPainter(connection,m);
        //Iter
        List copyOfPainter = new CopyOnWriteArrayList(m.getPainters());
        Iterator<Painter> iterator= copyOfPainter.listIterator();

        while(iterator.hasNext()){

        if(iterator.next().elementAt(x,y)) {

            painter.getConnection().setTo(x,y);

            }else{
                m.getPainters().remove(painter);
            }
        }


        painter = null;
        System.out.println("painters iz mispusten:" +m.getPainters());
        m.getMindMap().addElement(connection);

    }
}
