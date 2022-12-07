package raf.dsw.gerumap.state.stanja;

import raf.dsw.gerumap.state.State;

public class DeleteState extends State {
    @Override
    public void doStateAction(int x, int y) {
        System.out.println("BRISANJE");
    }
}
