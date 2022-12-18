package raf.dsw.gerumap.gui.swing.logger;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.LoggerInterface;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageGenImpl;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerInterface, ISubscriber {


    public FileLogger( MessageGenImpl messageGen) {
        messageGen.addSubs(this);
    }


    @Override
    public void update(Object notification) {
        log((Message) notification);
    }

    @Override
    public void log(Message message) {

        try {
            FileWriter fw = new FileWriter("src/main/resources/log.txt");

            fw.append(message.toString());
            fw.append("; ");

            fw.close();
        } catch (IOException e) {

            //To do alert umesto sout
            System.out.println("GRESKA: " + e.getMessage());

        }


    }
}
