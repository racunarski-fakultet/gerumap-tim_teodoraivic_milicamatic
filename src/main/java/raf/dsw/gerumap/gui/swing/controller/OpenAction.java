package raf.dsw.gerumap.gui.swing.controller;

import com.sun.tools.javac.Main;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenAction extends AbstractGeRuMapAction{

    public OpenAction() {
        putValue(NAME, "Open");
        putValue(SHORT_DESCRIPTION, "Open");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();

        if(jfc.showOpenDialog(MainFrame.getInstance())== JFileChooser.APPROVE_OPTION){
            try{
                File file = jfc.getSelectedFile();
                Project p = AppCore.getInstance().getSerializer().loadProject(file);
                MainFrame.getInstance().getMapTree().loadProject(p);
                MainFrame.getInstance().loadProjectView(p);
                //MainFrame.getInstance().showCurrentProjectView();
                System.out.println("pokazi projectview "+ MainFrame.getInstance().getProjectView());
                MainFrame.getInstance().paintNewElements();
                MindMap mindMap= (MindMap) p.getChildren().get(0);
                Concept c= (Concept) mindMap.getElements().get(0);
                System.out.println("iz load-a elementi "+ mindMap.getElements());

            }
            catch (Exception ex) {
                System.out.println("Message generator za ne pronadjen fajl");
                ex.printStackTrace();

            }

        }

    }
}
