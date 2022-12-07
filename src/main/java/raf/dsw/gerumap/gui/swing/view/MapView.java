package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;


        private ProjectView projectView;

        private TabbedPane tabs;



        @Override
        public void update(Object notification) {

        }


        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawRect(1000,100,30,30);
                g.drawString(" ",100,100);
                g.drawLine(10,10,20,20);

        }
}


