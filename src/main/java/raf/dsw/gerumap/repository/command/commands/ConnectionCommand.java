package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.Connection;

public class ConnectionCommand extends AbstractCommand {

    Connection connection;
    Painter painter;
    MapView mapView;
    float x,y;

    public ConnectionCommand(Connection connection, Painter painter, MapView mapView, float x, float y) {
        this.connection = connection;
        this.painter = painter;
        this.mapView = mapView;
        this.x = x;
        this.y = y;
    }

    @Override
    public void doCommand() {
        mapView.getPainters().add(painter);
        mapView.getMindMap().addElement(connection);

    }

    @Override
    public void undoCommand() {
        mapView.getPainters().remove(painter);
        mapView.getMindMap().removeElement(connection);

    }
}
