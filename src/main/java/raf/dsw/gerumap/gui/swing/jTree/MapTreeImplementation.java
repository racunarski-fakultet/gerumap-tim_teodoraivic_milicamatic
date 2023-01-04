package raf.dsw.gerumap.gui.swing.jTree;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeModel;
import raf.dsw.gerumap.gui.swing.jTree.view.MapTreeView;

import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.commands.AddCommand;
import raf.dsw.gerumap.repository.command.commands.DeleteCommand;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.factory.ElementFactory;
import raf.dsw.gerumap.repository.factory.MindMapFactory;
import raf.dsw.gerumap.repository.factory.ProjectFactory;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Random;

public class MapTreeImplementation implements MapTree {

    private MapTreeView treeView;

    private MapTreeModel treeModel;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);

        treeModel = new MapTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;

    }

    @Override
    public void addChild(MapTreeItem parent) {

        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        MapTreeItem childd=new MapTreeItem(child);
        parent.add(childd);

        AbstractCommand command=new AddCommand(parent,childd);

        AppCore.getInstance().getGui().getCommandManager().addCommand(command);

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
        return null;
    }

    public void removeChild(DefaultMutableTreeNode root){
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) root.getParent();
        treeModel.removeNodeFromParent(root);
        AbstractCommand command=new DeleteCommand((MapTreeItem) parent, (MapTreeItem) root);
        AppCore.getInstance().getGui().getCommandManager().addCommand(command);




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

    @Override
    public MapTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);

        treeModel.getRoot().add(loadedProject);
        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        mapNode.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

    }


}
