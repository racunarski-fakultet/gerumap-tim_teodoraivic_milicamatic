package raf.dsw.gerumap.gui.swing.jTree;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.jTree.view.MapTreeView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.factory.ElementFactory;
import raf.dsw.gerumap.repository.factory.MindMapFactory;
import raf.dsw.gerumap.repository.factory.ProjectFactory;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class MapTreeImplementation implements MapTree {

    private MapTreeView treeView;

    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;

    }

    @Override
    public void addChild(MapTreeItem parent) {

        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);


    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer)
            return new ProjectFactory().createNode("Project" + new Random().nextInt(100), parent);
        if (parent instanceof Project) {
            return new MindMapFactory().createNode("MindMap", parent);
        }
        if (parent instanceof MindMap)
            return new ElementFactory().createNode("Element", parent);
        //to do: napraviti brojac
        return null;
    }

    public void removeChild(DefaultMutableTreeNode root){
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) root.getParent(); // root je ono sto se brise
        treeModel.removeNodeFromParent(root);
        MapNode mapNodeParent = ((MapTreeItem)parent).getMapNode(); //pravljenje Node-a od parenta
        MapNode mapNodeChild = ((MapTreeItem)root).getMapNode(); // pravljenje node-a od root-a
        ((MapNodeComposite)mapNodeParent).removeChild(mapNodeChild);


    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void rename(MapTreeItem node, String newName) {
        node.setName(newName);
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
