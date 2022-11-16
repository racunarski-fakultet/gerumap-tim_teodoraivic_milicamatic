package raf.dsw.gerumap.core;

public class ApplicationFramework {

    protected GUI gui;
    protected static MapRepository mapRepository;
    protected static MessageGenerator messageGenerator;

    public void run(){
        this.gui.start();
    }

    public void initialise(GUI gui, MapRepository mapRepository, MessageGenerator messageGenerator){
        this.gui=gui;
        this.mapRepository=mapRepository;
        this.messageGenerator = messageGenerator;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public static MapRepository getMapRepository() {
        return mapRepository;
    }

    public static MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }
}
