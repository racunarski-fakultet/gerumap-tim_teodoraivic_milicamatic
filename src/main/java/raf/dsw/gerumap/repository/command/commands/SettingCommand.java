package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.*;
import java.util.List;

public class SettingCommand extends AbstractCommand {

    MapView mapView;
    int strokeSize;
    Paint color;

    public SettingCommand(MapView mapView, int strokeSize, Paint color) {
        this.mapView = mapView;
        this.strokeSize = strokeSize;
        this.color = color;
    }

    @Override
    public void doCommand() {

       if(!mapView.getMindMap().getSelectedElements().isEmpty()){
            mapView.getMindMap().setSelectedStroke(strokeSize);

        }
        else if(mapView.getMindMap().getElements().isEmpty()){
            mapView.getMindMap().initialStroke(strokeSize);
        }
        else{
            mapView.getMindMap().setNewStroke(strokeSize);
        }

    }

    @Override
    public void undoCommand() {

        List<Element>lista=mapView.getMindMap().getSelectedElements();




    }
}
