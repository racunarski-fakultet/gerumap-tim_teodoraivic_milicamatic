package raf.dsw.gerumap.gui.swing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SaveAsAction extends AbstractGeRuMapAction{


    public SaveAsAction() {
        putValue(NAME, "Save As");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();

        if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;



            if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());

        }

        try {
            AppCore.getInstance().getSerializer().saveProject(project);

        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
