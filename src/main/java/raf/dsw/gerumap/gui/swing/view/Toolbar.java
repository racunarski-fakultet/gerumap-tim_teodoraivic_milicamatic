package raf.dsw.gerumap.gui.swing.view;

import com.sun.tools.javac.Main;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;

public class Toolbar extends JToolBar {


    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        ActionManager actionManager = MainFrame.getInstance().getActionManager();

        add(actionManager.getNewAction());
        add(actionManager.getInfoAction());
        add(actionManager.getExitAction());
        add(actionManager.getDeleteAction());
        add(actionManager.getEditAction());
        add(actionManager.getAutorAction());



    }
}
