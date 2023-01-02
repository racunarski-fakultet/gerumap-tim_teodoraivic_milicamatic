package raf.dsw.gerumap;
import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.gui.swing.logger.ConsoleLogger;
import raf.dsw.gerumap.gui.swing.logger.FileLogger;
import raf.dsw.gerumap.gui.swing.message.MessageGenImpl;
import raf.dsw.gerumap.repository.MapRepositoryImpl;
import raf.dsw.gerumap.serializer.JacksonSerializer;

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
        MessageGenerator messageGenerator = new MessageGenImpl();
        GUI gui=new SwingGui((MessageGenImpl) messageGenerator);
        ApplicationFramework appCore=AppCore.getInstance();
        MapRepository mapRepository=new MapRepositoryImpl();
        ConsoleLogger consoleLogger = new ConsoleLogger((MessageGenImpl) messageGenerator);
        FileLogger fileLogger=new FileLogger((MessageGenImpl) messageGenerator);
        Serializer serializer = new JacksonSerializer();
        appCore.initialise(gui,mapRepository, messageGenerator,serializer);
        appCore.run();
    }

}
