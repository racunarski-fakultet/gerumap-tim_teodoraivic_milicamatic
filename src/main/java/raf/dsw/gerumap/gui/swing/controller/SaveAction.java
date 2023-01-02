package raf.dsw.gerumap.gui.swing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SaveAction extends AbstractGeRuMapAction{

    public SaveAction() {
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if(!project.isChanged()){
            return;
        }

        if(project.getFilePath() == null || project.getFilePath().isEmpty()){
            if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            }else{
                return;
            }
        }

        try {
            AppCore.getInstance().getSerializer().saveProject(project);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        project.setChanged(false);

    }
}
