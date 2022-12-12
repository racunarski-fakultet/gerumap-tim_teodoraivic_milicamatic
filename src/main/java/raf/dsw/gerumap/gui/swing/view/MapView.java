package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.controller.MapMouseListener;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;

import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;

        private ProjectView projectView;

        private TabbedPane tabs;

        private List<Painter>cloneList=new ArrayList<>(); //TODO lista treba negde da se clearuje


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

                this.mindMap.addSubs(this);


        }

        @Override
        public void update(Object notification) {

                System.out.println("uso u UPDATE u MV: " + notification);//udje

                if (notification.equals("dodatt element")) {
                        repaint();
                }

        }


        @Override
        protected void paintComponent(Graphics g) {

                System.out.println("usao u paintcomponent");
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

                System.out.println("izvrsen ceo paintComponent");

        }  ;//ovde treba da prolazi kroz listu svih paintera konkretna implementacija oblika ce biti u painterima




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


