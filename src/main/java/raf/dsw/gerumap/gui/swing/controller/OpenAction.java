package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenAction extends AbstractGeRuMapAction{

    public OpenAction() {
        //putValue(SMALL_ICON, loadIcon("/images/autor.png"));
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

            }
            catch (Exception ex) {
                System.out.println("Message generator za ne pronadjen fajl");
                ex.printStackTrace();

            }

        }

    }
}
