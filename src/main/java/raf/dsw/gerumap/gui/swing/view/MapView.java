package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.controller.MapMouseListener;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;

        private ProjectView projectView;

        private TabbedPane tabs;


        private List<Painter> painters=new ArrayList<>(); //element view-i, veza ili pojam, pripadaju grafici

        public MapView(LayoutManager layout, boolean isDoubleBuffered, MindMap mindMap,ProjectView pv) {
                super(layout, isDoubleBuffered);
                addMouseListener(new MapMouseListener());
                this.mindMap = mindMap;
                this.projectView=pv;
                this.setBackground(Color.WHITE);
               // addMouseListener(new MapMouseListener());
                Dimension min  = new Dimension(200,100);
                Dimension max = new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);
                Dimension pref = new Dimension(400,200);
                this.setMinimumSize(min);
                this.setMaximumSize(max);
                this.setPreferredSize(pref);


        }

        @Override
        public void update(Object notification) {


                if (notification.equals("dodat element")) {

                        repaint();
                }

        }


        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Painter p : painters){



                        p.draw((Graphics2D)g);//ovde treba da prolazi kroz listu svih paintera konkretna implementacija oblika ce biti u painterima
                }

        }

        public MindMap getMindMap() {
                return mindMap;
        }


        public List<Painter> getPainters() {
                return painters;
        }

        public void setMindMap(MindMap mindMap) {
                this.mindMap = mindMap;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                MapView mapView = (MapView) o;
                return Objects.equals(mindMap, mapView.mindMap);
        }

        @Override
        public int hashCode() {
                return Objects.hash(mindMap);
        }
}


