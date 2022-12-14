package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.ConceptDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConceptState extends State{

  Concept c;
  List<Painter> copyPainters = new ArrayList();
  boolean isTaken=false;


  @Override
  public void misKliknut(int x, int y, MapView m) { //kliknut

    c=new Concept("koncept", m.getMindMap(),x,y);

    Painter painter = new ConceptPainter(c, m);


    for (Painter p : m.getPainters()) {
      copyPainters.add(p);

    }
    Iterator<Painter> iterator = copyPainters.listIterator();

    for(Painter p: copyPainters){
      if (p.elementAt(x,y)){
        isTaken=true;
        System.out.println("zauzeto mesto");
        break;
      }
    }
    if (!isTaken){
      ConceptDialog conceptDialog=new ConceptDialog(MainFrame.getInstance(),c);
      conceptDialog.setVisible(true);

      m.getMindMap().addElement(c);
      m.getPainters().add(painter);
    }
    isTaken=false;


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
