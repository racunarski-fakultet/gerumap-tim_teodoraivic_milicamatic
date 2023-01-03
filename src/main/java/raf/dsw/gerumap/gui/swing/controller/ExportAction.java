package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.MyChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportAction extends AbstractGeRuMapAction{

    MapView mapView;// current view
    File file;
    MyChooser fc= new MyChooser();


    public ExportAction() {
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(SHORT_DESCRIPTION, "Export");
    }

    int retVal;
    private String getWhereToSave(){
        if(retVal == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fc.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        retVal = fc.showSaveDialog(MainFrame.getInstance());
        if(retVal == JFileChooser.APPROVE_OPTION) {
            mapView = (MapView) MainFrame.getInstance().getProjectView().getTp().getSelectedComponent();
            try {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(mapView.getLocationOnScreen().x, mapView.getLocationOnScreen().y, mapView.getWidth(), mapView.getHeight()));
                ImageIO.write(image, "png", new File(getWhereToSave() + ".png"));
            } catch (AWTException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

