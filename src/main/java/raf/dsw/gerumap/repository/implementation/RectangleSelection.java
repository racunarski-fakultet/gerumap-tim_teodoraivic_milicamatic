package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class RectangleSelection implements IPublisher {
    float x,y;
    private List<ISubscriber> subscribers;


    public RectangleSelection(float x, float y) {
        this.x = x;
        this.y = y;
        subscribers = new ArrayList<>();

    }

    public void notifyRectangle(){

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setCoordinates(float x , float y){
        this.x=x;
        this.y=y;
        notifySubscribers("RectangleSelection");
        System.out.println("usao u notifymetodu");


    }

    @Override
    public void notifySubscribers(Object notification) {

        for(ISubscriber sub : subscribers){
            sub.update(notification);
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
