package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.controller.MapMouseListener;
import raf.dsw.gerumap.gui.swing.controller.MouseMotionListen;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;

import raf.dsw.gerumap.gui.swing.view.painters.SelectionPainter;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.RectangleSelection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

        private MindMap mindMap;

        private ProjectView projectView;


        private List<Painter>cloneList=new ArrayList<>();

        private SelectionPainter selectionPainter=null;

        private RectangleSelection rectangleSelection;

        private List<Painter> painters=new ArrayList<>();

        private List<Painter> selectedPainters = new ArrayList<>();

        private ConnectionPainter connectionPainter;

        private Connection connection;


        public MapView(LayoutManager layout, boolean isDoubleBuffered, MindMap mindMap,ProjectView pv) {
                super(layout, isDoubleBuffered);
                addMouseListener(new MapMouseListener());
                addMouseMotionListener(new MouseMotionListen());
                this.mindMap = mindMap;
                this.projectView=pv;
                this.setBackground(Color.WHITE);

                Dimension min  = new Dimension(200,100);
                Dimension max = new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);
                Dimension pref = new Dimension(400,200);
                this.setMinimumSize(min);
                this.setMaximumSize(max);
                this.setPreferredSize(pref);

                this.mindMap.addSubs(this);
                projectView.getProject().addSubs(this);



        }

        @Override
        public void update(Object notification) {



                if (notification.equals("dodatt element")) {
                       mindMap.getElements().get(mindMap.getElements().size()-1).addSubs(this);
                        repaint();
                }
                if (notification.equals("krajnje koord")){
                        repaint();
                }
                if(notification.equals("dodat selected element")){
                        repaint();
                }
                if (notification.equals("dodat selected")){

                        repaint();
                }
                if (notification.equals("color changed")){

                        repaint();
                }
                if(notification.equals("obrisan element")){
                        repaint();

                }
                if (notification.equals("RectangleSelection")){

                        repaint();
                }
                if (notification.equals("krajnja")){

                        repaint();
                }
                if (notification.equals("pocetne koord")){
                        repaint();
                }
                if(notification.equals("mindMap ADDED")){
                        repaint();
                }
                if (notification.equals("repaint")){
                        repaint();
                }




        }


        @Override
        protected void paintComponent(Graphics g) {


                super.paintComponent(g);
                for (Painter p:painters){
                        cloneList.add(p);
                }

                Graphics2D g2=(Graphics2D) g;

                if (selectionPainter!=null){
                        selectionPainter.draw(g2);
                }
                selectionPainter=null;

                if (connectionPainter!=null){
                        connectionPainter.draw(g2);
                }
                connectionPainter=null;

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

        public SelectionPainter getSelectionPainter() {
                return selectionPainter;
        }

        public void setSelectionPainter(SelectionPainter selectionPainter) {
                this.selectionPainter = selectionPainter;
        }

        public RectangleSelection getRectangleSelection() {
                return rectangleSelection;
        }

        public void setRectangleSelection(RectangleSelection rectangleSelection) {
                this.rectangleSelection = rectangleSelection;
                if (rectangleSelection!=null) {
                        this.rectangleSelection.addSubs(this);
                }

        }

        public List<Painter> getSelectedPainters() {
                return selectedPainters;
        }

        public void setSelectedPainters(List<Painter> selectedPainters) {
                this.selectedPainters = selectedPainters;
        }

        public ConnectionPainter getConnectionPainter() {
                return connectionPainter;
        }

        public void setConnectionPainter(ConnectionPainter connectionPainter){
                this.connection=connection;

        }

        public Connection getConnection() {
                return connection;
        }

        public void setConnection(Connection connection) {
                this.connection = connection;
                if (connection!=null){
                        this.connection.addSubs(this);
                }
        }

}


