package raf.dsw.gerumap.gui.swing.jTree.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class  MapTreeSelectionListener implements TreeSelectionListener {



    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem) path.getLastPathComponent();
        System.out.println("Selektovan cvor je " + treeItemSelected.getMapNode().getName());
        System.out.println("Putanja je" + e.getPath());

    }
}
