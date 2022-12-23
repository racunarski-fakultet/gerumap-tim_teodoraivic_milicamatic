package raf.dsw.gerumap.gui.swing.jTree;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.jTree.view.MapTreeView;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.tree.DefaultMutableTreeNode;


public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);

    void addChild(MapTreeItem parent);

    MapTreeItem getSelectedNode();

    void removeChild(DefaultMutableTreeNode root);

    void rename(MapTreeItem node, String newName);

    MapTreeView getTreeView();

}
