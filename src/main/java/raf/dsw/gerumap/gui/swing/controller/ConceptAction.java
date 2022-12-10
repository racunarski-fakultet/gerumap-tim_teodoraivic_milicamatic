package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.ConceptDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.composite.MapNode;

import java.awt.event.ActionEvent;

public class ConceptAction extends AbstractGeRuMapAction{

    public ConceptAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        putValue(SMALL_ICON, loadIcon("/images/concept.png"));
        putValue(SHORT_DESCRIPTION, "Concept");

        MainFrame m = MainFrame.getInstance();

        ProjectView projectView = m.getProjectView();

        projectView.startConceptState();

        projectView.getCurrentState();




    }
}
