package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.ConceptDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.state.State;

import java.util.Iterator;

public class ConceptState extends State{

  Concept c;

  @Override
  public void misKliknut(int x, int y, MapView m) { //kliknut
    //ovo ovde treba da izmeni model tkd metoda za dodavanje Concepta u listu Elemenata
   // onda observer obavestava MapView i on radi update(repaint) i paintcomponent


    c=new Concept("koncept", m.getMindMap(),x,y);

    ConceptDialog conceptDialog=new ConceptDialog(MainFrame.getInstance(),c);
    conceptDialog.setVisible(true);



    Painter painter = new ConceptPainter(c, m);





    if(m.getPainters().isEmpty()){
      m.getPainters().add(painter);
    }



//      for (Painter p : m.getPainters()) {
//        if (p.elementAt(x, y)) {
//          //TODO message generator
//          System.out.println("Uso u break");
//          break;
//        } else {
//          m.getPainters().add(painter);
//        }


    m.getMindMap().addElement(c);
    m.getPainters().add(painter);


    System.out.println("dodat painter u listu miskliknut:" + painter);
    System.out.println(m.getPainters());



    System.out.println("ELIPSA u koordinatama: X="+x+", Y="+y);

  }

  @Override
  public void misPritisnut(int x, int y, MapView m) {
    super.misPritisnut(x, y, m);
  }

  @Override
  public void misPusten(int x, int y, MapView m) {
    super.misPusten(x, y, m);
  }


}
