package raf.dsw.gerumap.core;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface ISubscriber {


    void update(Object notification);

}
