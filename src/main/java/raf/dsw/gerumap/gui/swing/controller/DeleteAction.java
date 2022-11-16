package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.message.EventType;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageType;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static raf.dsw.gerumap.gui.swing.message.EventType.CanNotDeleteRoot;

public class DeleteAction extends AbstractGeRuMapAction {


    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }


    EventType eventType;
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if (selected.isRoot()){
            eventType=CanNotDeleteRoot;
            ApplicationFramework.getMessageGenerator().generateMessage(new Message("Ne moze se izbrisati projectExplorer", MessageType.ERROR, eventType));

        }else {

            MainFrame.getInstance().getMapTree().removeChild(selected);
        }

    }

    public EventType getEventType() {
        return eventType;
    }

}
