package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.ConceptDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.state.State;

public class ConceptState extends State{

  Concept c;

  @Override
  public void misKliknut(int x, int y, MapView m) { //kliknut
    //ovo ovde treba da izmeni model tkd metoda za dodavanje Concepta u listu Elemenata
   // onda observer obavestava MapView i on radi update(repaint) i paintcomponent

    ConceptDialog conceptDialog=new ConceptDialog(MainFrame.getInstance());
    conceptDialog.setVisible(true);


//    System.out.println(m.getMindMap() + "iz concept state mindmap");


    c=new Concept(conceptDialog.getName(), m.getMindMap(),x,y);


    m.getMindMap().addElement(c); //mora da se inicijalizuje mindmap

    // x,y settovati conceptu
    System.out.println("ELIPSA u koordinatama: X="+x+", Y="+y);

  }

  @Override
  public void misPritisnut(int x, int y) {

  }
}
