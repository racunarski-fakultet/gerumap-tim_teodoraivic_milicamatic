package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;

public class Toolbar2 extends JToolBar{

    public Toolbar2(){
        super(VERTICAL);
        setFloatable(false);

        ActionManager actionManager=MainFrame.getInstance().getActionManager();

        add(actionManager.getSelectionAction());
        add(actionManager.getMoveAction());
        add(actionManager.getLinkAction());
        add(actionManager.getConceptAction());
        add(actionManager.getSettingAction());

    }
}
