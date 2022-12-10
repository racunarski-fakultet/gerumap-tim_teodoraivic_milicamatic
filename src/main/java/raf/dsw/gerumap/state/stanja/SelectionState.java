package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.state.State;

public class SelectionState extends State {

    @Override
    public void misKliknut(int x, int y, MapView m) {
        super.misKliknut(x, y, m);
        for (Painter p : m.getPainters()){
           // p.elementAt(); //argumenti u elementAt treba da budu x,y dobijeni iz misKliknut
        }

    }
}
