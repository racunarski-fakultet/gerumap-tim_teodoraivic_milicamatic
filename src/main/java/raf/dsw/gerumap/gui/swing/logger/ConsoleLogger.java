package raf.dsw.gerumap.gui.swing.logger;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.LoggerInterface;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageGenImpl;

public class ConsoleLogger implements ISubscriber, LoggerInterface {
    public ConsoleLogger(MessageGenImpl messageGen) {
        messageGen.addSubs(this);

    }

    @Override
    public void update(Object notification) {

        log((Message) notification);

    }


    @Override
    public void log(Message message) {
        System.out.println(message.toString());
    }
}
