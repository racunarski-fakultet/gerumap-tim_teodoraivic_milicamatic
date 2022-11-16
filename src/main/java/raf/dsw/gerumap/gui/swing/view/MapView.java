package raf.dsw.gerumap.gui.swing.view;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;

import javax.swing.*;

public class MapView extends JPanel implements ISubscriber {


        @Override
        public void update(Object notification) {
            if(notification.equals("mindmap removed")) {

            }
            if(notification.equals("mindmap added")){

            }

        }
}


