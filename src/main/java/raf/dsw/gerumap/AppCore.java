package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.repository.MapRepositoryImpl;

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
        GUI gui=new SwingGui();
        ApplicationFramework appCore=AppCore.getInstance(); ///////////
        MapRepository mapRepository=new MapRepositoryImpl();
        appCore.initialise(gui,mapRepository);
        appCore.run();
    }

}
