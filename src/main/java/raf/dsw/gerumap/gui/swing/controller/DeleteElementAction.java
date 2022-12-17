package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.implementation.Element;

import java.awt.event.ActionEvent;
import java.util.List;

import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;

public class DeleteElementAction extends AbstractGeRuMapAction{

    public DeleteElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/delete1.png"));
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {




        MainFrame m = MainFrame.getInstance(); //nasa aplikacija

        ProjectView projectView = m.getProjectView(); //nas mediator

        projectView.startDeleteState(); //zapocni stanje brisanja

        projectView.getCurrentState();

//        List<Element> selectedElements = projectView.getMapView().getMindMap().getSelectedElements();
//
//        System.out.println("Lista selektovanih iz actiona je" + selectedElements);
//
//        MapView mapView = (MapView) projectView.getTp().getSelectedComponent();
//
//
//
//        if(!selectedElements.isEmpty()){
//            // treba da se uklone elementi i njihovi painteri iz liste
//            for(Element element: selectedElements){
//
//
//            }
//
//        }

    }
}


