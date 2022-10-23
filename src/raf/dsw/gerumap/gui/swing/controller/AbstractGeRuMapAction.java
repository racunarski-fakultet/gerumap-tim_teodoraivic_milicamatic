package raf.dsw.gerumap.gui.swing.controller;
import javax.swing.*;
import java.net.URL;


public abstract class AbstractGeRuMapAction extends AbstractAction {//osnovna implementacija action listenera

    public Icon loadIcon(String FileName){

        URL imageURL = getClass().getResource(FileName);
        Icon icon = null;

        if(imageURL != null){
            icon = new ImageIcon(imageURL);
        }
        else{
            System.err.println("Resource not found: " + FileName);
        }

        return icon;

    }
}
