package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAsAction extends AbstractGeRuMapAction{


    public SaveAsAction() {
        putValue(NAME, "Save As");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();

    }
}
