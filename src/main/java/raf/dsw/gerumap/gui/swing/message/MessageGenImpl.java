package raf.dsw.gerumap.gui.swing.message;
import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.MessageGenerator;
import java.util.ArrayList;
import java.util.List;

public class MessageGenImpl implements MessageGenerator, IPublisher {

    private List<ISubscriber> subscribers;


    public MessageGenImpl() {

        subscribers=new ArrayList<>();

    }

    @Override
    public Message generateMessage(Message message) {
        if (message.eventType == EventType.CanNotDeleteRoot){
            notifySubscribers(message);
        }
        else if (message.eventType == EventType.BlankStringForName){
            notifySubscribers(message);
        }

        return null;
    }


    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber subscriber: subscribers){
            subscriber.update(notification);
        }
    }

    @Override
    public void addSubs(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        subscribers.remove(sub);

    }
}
