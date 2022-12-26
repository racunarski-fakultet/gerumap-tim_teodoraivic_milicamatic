package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Project;

public class ConceptCommand extends AbstractCommand {

    Concept concept;
    Painter conceptPainter;
    MapView mapView;
    float x,y;
    Project project;

    public ConceptCommand(Concept concept, Painter painter, MapView mapView, float x, float y) {
        this.concept = concept;
        this.conceptPainter = painter;
        this.mapView = mapView;
        this.x = x;
        this.y = y;
        project=mapView.getMindMap().getP();

    }

    @Override
    public void doCommand() {
        mapView.getPainters().add(conceptPainter);
        mapView.getMindMap().addElement(concept);
        project.setChanged(true);
    }

    @Override
    public void undoCommand() {
        mapView.getPainters().remove(conceptPainter);
        mapView.getMindMap().removeElement(concept);
        project.setChanged(true);


    }
}
