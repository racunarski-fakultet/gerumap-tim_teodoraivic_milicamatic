package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;

        private ProjectView projectView;

        private TabbedPane tabs;


        private List<Painter> painters;

        public MapView(LayoutManager layout, boolean isDoubleBuffered, MindMap mindMap) {
                super(layout, isDoubleBuffered);
                this.mindMap = mindMap;


        }


        @Override
        public void update(Object notification) {
                // repaint()
        }


        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               // g.drawRect(1000,100,30,30);
              //  g.drawString(" ",100,100);
              //  g.drawLine(10,10,20,20);
                for(Painter p : painters){
                        //p.draw(g);  //ovde treba da prolazi kroz listu svih paintera konkretna implementacija oblika ce biti u painterima
                }

        }

        public MindMap getMindMap() {
                return mindMap;
        }
}


