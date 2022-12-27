package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportAction extends AbstractGeRuMapAction{

    MapView mapView;// current view

    public ExportAction() {
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(SHORT_DESCRIPTION, "Export");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        mapView= (MapView) MainFrame.getInstance().getProjectView().getTp().getSelectedComponent();

        File file = new File("fileName.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            BufferedImage image=new Robot().createScreenCapture(new Rectangle(mapView.getLocationOnScreen().x,
                    mapView.getLocationOnScreen().y,mapView.getWidth(),mapView.getHeight()));
            ImageIO.write(image,"png", file);
        } catch (AWTException | IOException ex) {
            ex.printStackTrace();
        }


    }
}
