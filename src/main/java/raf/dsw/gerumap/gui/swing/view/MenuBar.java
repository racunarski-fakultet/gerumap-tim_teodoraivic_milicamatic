package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar(){

        ActionManager actionManager = MainFrame.getInstance().getActionManager();



        JMenu fileMenu=new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(actionManager.getExitAction());
        fileMenu.add(actionManager.getNewAction());
        fileMenu.add(actionManager.getInfoAction());
        fileMenu.add(actionManager.getDeleteAction());
        fileMenu.add(actionManager.getEditAction());
        fileMenu.add(actionManager.getAutorAction());


        this.add(fileMenu);
        this.add(helpMenu);

    }
}
