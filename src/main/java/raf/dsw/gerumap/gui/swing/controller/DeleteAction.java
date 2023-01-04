package raf.dsw.gerumap.gui.swing.controller;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.message.EventType;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageType;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

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
        MainFrame m = MainFrame.getInstance();

        MapTreeItem selected = m.getMapTree().getSelectedNode();

        MapNode mapNode = selected.getMapNode();

        ProjectView projectView = m.getProjectView();



        JPanel desktop = m.getDesktop();

        if (selected.isRoot()){
            eventType=CanNotDeleteRoot;
            ApplicationFramework.getMessageGenerator().generateMessage(new Message("Ne moze se izbrisati projectExplorer", MessageType.ERROR, eventType));



        }


        else if(selected.getMapNode() instanceof MindMap) {
            // brisanje mind mapa
            m.getMapTree().removeChild(selected);
            if (projectView != null) {
                projectView.getTp().removeAll();
                projectView.setTabbedPane();
            }


            desktop.revalidate();

        }else if (projectView==null){
                m.getMapTree().removeChild(selected);
                ((Project) selected.getMapNode()).getChildren().clear();
            }

        else if(selected.getMapNode() instanceof Project){
            m.getMapTree().removeChild(selected);
            ((Project) selected.getMapNode()).getChildren().clear();
            projectView.getMaps().clear();
            projectView.remove(projectView.getTp());
            desktop.repaint();
            desktop.removeAll();
            desktop.revalidate();
        }
       

    }

    public EventType getEventType() {
        return eventType;
    }

}
