package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.state.State;

public class ConceptState extends State{
  @Override
  public void doStateAction(int x, int y) {
    //TODO
    //Stampanje elipse, painter klasa

    System.out.println("ELIPSA u koordinatama: X="+x+", Y="+y);
  }

}
