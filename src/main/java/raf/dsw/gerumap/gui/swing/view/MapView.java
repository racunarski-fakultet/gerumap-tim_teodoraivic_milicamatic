package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.controller.MapMouseListener;
import raf.dsw.gerumap.gui.swing.controller.MouseMotionListen;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;

import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;

        private ProjectView projectView;

        private TabbedPane tabs;

        private List<Painter>cloneList=new ArrayList<>();


        private List<Painter> painters=new ArrayList<>(); //element view-i, veza ili pojam, pripadaju grafici

        public MapView(LayoutManager layout, boolean isDoubleBuffered, MindMap mindMap,ProjectView pv) {
                super(layout, isDoubleBuffered);
                addMouseListener(new MapMouseListener());
                addMouseMotionListener(new MouseMotionListen());
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

                this.mindMap.addSubs(this);


        }

        @Override
        public void update(Object notification) {



                if (notification.equals("dodatt element")) {
                        repaint();
                }
                if (notification.equals("krajnje koord")){
                        repaint();
                }
                if(notification.equals("dodat selected element")){
                        repaint();
                }


        }


        @Override
        protected void paintComponent(Graphics g) {


                super.paintComponent(g);
                System.out.println("painters iz pc" + painters);
                for (Painter p:painters){
                        cloneList.add(p);
                }
                System.out.println("CloneLista: " + cloneList);

                Graphics2D g2=(Graphics2D) g;

                Iterator<Painter> iterator= cloneList.listIterator();
                while(iterator.hasNext()){
                        iterator.next().draw(g2);

                }
                cloneList.clear();



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


}


