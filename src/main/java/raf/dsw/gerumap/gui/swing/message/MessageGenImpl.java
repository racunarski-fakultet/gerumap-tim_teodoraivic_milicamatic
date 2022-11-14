package raf.dsw.gerumap.gui.swing.message;


import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.MessageGenerator;

public abstract class MessageGenImpl implements MessageGenerator, IPublisher {

    private Message message;


    @Override
    public Message generateMessage() {
        return null;
    }


    @Override
    public void notifySubscribers(Object notification) {

    }

    @Override
    public void addSubs(ISubscriber sub) {

    }

    @Override
    public void removeSubs(ISubscriber sub) {

    }
}
