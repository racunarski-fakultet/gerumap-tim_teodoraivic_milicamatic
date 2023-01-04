package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class DeleteCommand extends AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem root;

    public DeleteCommand(MapTreeItem parent, MapTreeItem root) {
        this.parent = parent;
        this.root = root;
    }

    @Override
    public void doCommand() {
        if(root == null ||  parent==null) return;
        root.removeFromParent();
        ((MapNodeComposite) parent.getMapNode()).removeChild(root.getMapNode());

    }

    @Override
    public void undoCommand() {
        if(root == null ||  parent==null) return;
        parent.add(root);
        ((MapNodeComposite) parent.getMapNode()).addChild(root.getMapNode());

    }
}
