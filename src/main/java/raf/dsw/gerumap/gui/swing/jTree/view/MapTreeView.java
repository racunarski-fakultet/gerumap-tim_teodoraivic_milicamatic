package raf.dsw.gerumap.gui.swing.jTree.view;

import raf.dsw.gerumap.gui.swing.jTree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.jTree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel){
        setModel(defaultTreeModel);

        MapTreeCellRenderer ruTreeCellRenderer=new MapTreeCellRenderer();

        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);

    }
}
