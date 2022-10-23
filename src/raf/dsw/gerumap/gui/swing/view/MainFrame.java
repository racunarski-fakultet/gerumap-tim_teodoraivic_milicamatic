package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance;

    private ActionManager actionManager;

    private JMenuBar menuBar;

    private JToolBar toolBar;

    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
        initialiseGUI();
    }

    private void initialiseGUI(){

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

        //pravim po jedan panel za radnu povrsinu i za project explore
        JPanel desktop=new JPanel();

        JScrollPane scroll=new JScrollPane();
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

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

}
