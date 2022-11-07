package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.gui.swing.SwingGui;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;


    private AppCore(){

    }

    public static AppCore getInstance(){
        if (instance==null){
            instance = new AppCore();
        }        return instance;
    }

    public void run(){
        this.gui.start();
    }

    public static void main(String[] args) {
        //test
        GUI gui=new SwingGui();
        ApplicationFramework appCore=AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();
    }

}
