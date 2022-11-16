package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.gui.swing.view.EditDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractGeRuMapAction{


    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        EditDialog editDialog=new EditDialog(MainFrame.getInstance(), "Edit", MainFrame.getInstance().getMapTree().getSelectedNode());
        editDialog.setVisible(true);
        editDialog.setModal(true); //jedini otvoren prozor




    }
}
