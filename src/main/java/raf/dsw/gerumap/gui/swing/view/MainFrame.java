package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.controller.MyMouseListener;
import raf.dsw.gerumap.gui.swing.jTree.MapTree;
import raf.dsw.gerumap.gui.swing.jTree.MapTreeImplementation;
import raf.dsw.gerumap.gui.swing.jTree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.painters.ConceptPainter;
import raf.dsw.gerumap.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.gerumap.gui.swing.view.painters.Painter;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private static MainFrame instance;

    private ActionManager actionManager;

    private JMenuBar menuBar;

    private JToolBar toolBar;

    private InfoDialog infoDialog;

    private MapTree mapTree;

    private MapTreeView projectExplorer;

    private JPanel desktop;

    private ProjectView projectView;

    private MapView mapView;

    List<ProjectView>projectViewList;


    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
        mapTree=new MapTreeImplementation();
        projectExplorer=mapTree.generateTree(ApplicationFramework.getMapRepository().getProjectExplorer());
        projectExplorer.addMouseListener(new MyMouseListener());
        initialiseGUI(projectExplorer);
        projectViewList=new ArrayList<>();
    }

    public void showCurrentProjectView() {
        MapNode currentMapNode = this.getMapTree().getSelectedNode().getMapNode();

        if(currentMapNode instanceof Project) {
            Project pr = (Project)currentMapNode;
            ProjectView pv = this.replaceProjectView();
//            pv.setMaps(pr.getChildren());
//            pv.setTabbedPane();
//            desktop.removeAll();
//            desktop.add(pv);
//            desktop.revalidate();
//            desktop.repaint();
            if(!this.getProjectViewList().contains(pv)) {
                System.out.println("contains je false");
                pv.setMaps(pr.getChildren());
                pv.setTabbedPane();
                desktop.removeAll();
                desktop.add(pv);
                desktop.revalidate();
                desktop.repaint();
                this.getProjectViewList().add(pv);
                projectView = pv;

            }else{
                desktop.removeAll();
                desktop.add(pv);
                desktop.revalidate();
                desktop.repaint();
                System.out.println("contains je true");
                projectView = pv;
            }
        }
        System.out.println("SHOW PV: "+MainFrame.getInstance().getProjectView());

    }
    public void loadProjectView(Project project){
        projectView = new ProjectView(project);

        //if(!this.getProjectViewList().contains(pv)) {
            projectView.setMaps(project.getChildren());
             projectView.setTabbedPane();
            desktop.removeAll();
            desktop.add(projectView);
            desktop.revalidate();
            desktop.repaint();
            this.getProjectViewList().add(projectView);
            //projectView = pv;

       // }
        System.out.println("LOAD PV "+ projectView);

        }

    public void paintNewElements(){

        Painter painter;
        for (MapView mapView: projectView.getMapViews()) {
            for (Element element : mapView.getMindMap().getElements()) {
                if (element instanceof Concept) {
                    painter = new ConceptPainter(element, mapView);
                } else {
                    painter = new ConnectionPainter(element, mapView);
                }
                mapView.getPainters().add(painter);

                System.out.println("pPAINTERS iz nove metode " + mapView.getPainters());
            }
        }


    }

    public void addNewMindMap(){
        MapNode currentMapNode = this.getMapTree().getSelectedNode().getMapNode();
        //MapTreeItem = this.getMapTree().getSelectedNode();

        if(currentMapNode instanceof Project){
            if(projectView != null){
                Project p = (Project) currentMapNode;

                MindMap m = (MindMap) p.getChildren().get(p.getChildren().size()-1);

                projectView.getTp().addATab(m);
                projectView.setMaps(p.getChildren());

                desktop.revalidate();
                desktop.repaint();

            }



        }


        // treba mi da se na tabbedpane doda novi tab
        //

    }

    private void initialiseGUI(MapTreeView projectExplorer){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        setSize(screenWidth/2,screenHeight/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        infoDialog = new InfoDialog(this);



        //pravim po jedan panel za radnu povrsinu i za project explore
        desktop=new JPanel();


        JScrollPane scroll=new JScrollPane(this.projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    private ProjectView replaceProjectView() {



        if (!projectViewList.isEmpty()) {
            for (ProjectView pv : projectViewList) {
                if (pv.getProject().equals((Project) this.getMapTree().getSelectedNode().getMapNode())) {
                    System.out.println("Uso u if replace project viewa");
                    projectView = pv;
                    return projectView;
                }
            }
        }
        System.out.println("nije uso u if replace projecta");


            projectView = new ProjectView((Project) this.getMapTree().getSelectedNode().getMapNode());
            //projectViewList.add(projectView);



        return projectView;
//
    }

    public ProjectView getProjectView() {
        return this.projectView;
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager(){
        return actionManager;
    }

    public InfoDialog getInfoDialog() { return infoDialog; }

    public MapTree getMapTree() {
        return mapTree;
    }

    public void setMapTree(MapTree mapTree) {
        this.mapTree = mapTree;
    }

    public JPanel getDesktop() {
        return desktop;
    }

    public List<ProjectView> getProjectViewList() {
        return projectViewList;
    }

    public void setProjectViewList(List<ProjectView> projectViewList) {
        this.projectViewList = projectViewList;
    }
}
