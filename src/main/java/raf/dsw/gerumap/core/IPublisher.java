package raf.dsw.gerumap.core;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface IPublisher {

    void notifySubscribers(Object notification);

    void addSubs(ISubscriber sub);

    void removeSubs(ISubscriber sub);


}
