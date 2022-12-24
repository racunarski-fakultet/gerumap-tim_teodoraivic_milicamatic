package raf.dsw.gerumap.core;

public class ApplicationFramework {

    protected GUI gui;
    protected static MapRepository mapRepository;
    protected static MessageGenerator messageGenerator;

    protected Serializer serializer;

    public void run(){
        this.gui.start();
    }

    public void initialise(GUI gui, MapRepository mapRepository, MessageGenerator messageGenerator, Serializer serializer){
        this.gui=gui;
        this.mapRepository=mapRepository;
        this.messageGenerator = messageGenerator;
        this.serializer = serializer;
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

    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }
}
