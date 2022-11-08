package raf.dsw.gerumap.gui.swing.jTree.view;



import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MapTreeCellRenderer extends DefaultTreeCellRenderer {


    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
        super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
        URL imageURL=null;

        if (((MapTreeItem)value).getMapNode() instanceof ProjectExplorer){
            imageURL = getClass().getResource("/images/search.png");

        } else if(((MapTreeItem)value).getMapNode() instanceof Project){
            imageURL = getClass().getResource("/images/project.png");
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }

}
