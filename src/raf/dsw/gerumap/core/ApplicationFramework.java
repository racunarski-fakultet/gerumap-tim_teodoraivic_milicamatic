package raf.dsw.gerumap.core;

public abstract class ApplicationFramework {

    protected GUI gui;

    public abstract void run();

    public void initialise(GUI gui){
        this.gui=gui;
    }
}
