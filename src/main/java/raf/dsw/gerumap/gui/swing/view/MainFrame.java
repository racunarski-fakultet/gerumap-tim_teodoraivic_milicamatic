package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.controller.MyMouseListener;
import raf.dsw.gerumap.gui.swing.jTree.MapTree;
import raf.dsw.gerumap.gui.swing.jTree.MapTreeImplementation;
import raf.dsw.gerumap.gui.swing.jTree.view.MapTreeView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;

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

    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
        mapTree=new MapTreeImplementation();
        projectExplorer=mapTree.generateTree(ApplicationFramework.getMapRepository().getProjectExplorer());
        projectExplorer.addMouseListener(new MyMouseListener());
        initialiseGUI(projectExplorer);
    }

    public void showCurrentProjectView() {
        MapNode currentMapNode = this.getMapTree().getSelectedNode().getMapNode();

        if(currentMapNode instanceof Project) {
            desktop.removeAll();
            desktop.add(this.getProjectView());
            desktop.revalidate();
            desktop.repaint();
        }
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

    private void replaceProjectView() {
        projectView = new ProjectView((Project) this.getMapTree().getSelectedNode().getMapNode());
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


}
