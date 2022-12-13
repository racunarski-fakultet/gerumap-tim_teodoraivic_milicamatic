package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.state.State;

public class ConnectionState extends State {

    Connection connection;

    @Override
    public void misKliknut(int x, int y, MapView m) {
        super.misKliknut(x, y, m);
    }

    @Override
    public void misPritisnut(int x, int y, MapView m) {
        //treba da dobijemo concept od kog krecemo
        //
        // super.misPritisnut(x, y, m);

        connection=new Connection("veza", m.getMindMap());
        for(Painter p : m.getPainters()){
            if(p.elementAt(x,y)){
                ConceptPainter cp = (ConceptPainter) p;
                connection.setFrom(cp.getConcept());
                break;
            }
        }
        float x1,y1;
        x1=x;
        y1=y;
        connection.setX1(x);
        connection.setY1(y);
        //u ovoj metodi samo dodeljujem pocetne koordinate

    }

    @Override
    public void misPusten(int x, int y, MapView m) {
        //super.misPusten(x, y, m);
        float x2,y2;
        x2=x;
        y2=y;
        connection.setX2(x);
        connection.setY2(y);

        Painter painter=new ConnectionPainter(connection,m);

        for(Painter p : m.getPainters()){
            if(p.elementAt(x,y)){
                ConceptPainter cp = (ConceptPainter) p;
                connection.setTo(cp.getConcept());
                break;
            }
        }

        m.getPainters().add(painter);
        System.out.println("painters iz mispusten:" +m.getPainters());
        m.getMindMap().addElement(connection);

    }
}
