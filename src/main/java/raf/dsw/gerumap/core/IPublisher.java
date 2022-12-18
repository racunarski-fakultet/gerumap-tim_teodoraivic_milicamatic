package raf.dsw.gerumap.core;

public interface IPublisher {

    void notifySubscribers(Object notification);

    void addSubs(ISubscriber sub);

    void removeSubs(ISubscriber sub);


}
