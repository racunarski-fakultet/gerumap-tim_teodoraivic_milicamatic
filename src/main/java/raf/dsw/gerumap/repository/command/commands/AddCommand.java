package raf.dsw.gerumap.repository.command.commands;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class AddCommand extends AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem child;

    public AddCommand(MapTreeItem parent, MapTreeItem child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {
        if(child == null ||  parent==null) return;
        parent.add(child);
        ((MapNodeComposite) parent.getMapNode()).addChild(child.getMapNode());

    }

    @Override
    public void undoCommand() {
        if(child == null ||  parent==null) return;
        child.removeFromParent();
        ((MapNodeComposite)(parent.getMapNode())).removeChild(child.getMapNode());

    }
}
