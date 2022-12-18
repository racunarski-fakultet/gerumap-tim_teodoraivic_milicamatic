package raf.dsw.gerumap.gui.swing.jTree.controller;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;

    private JTextField edit = null;

    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean isExpended, boolean isLeaf, int row){
        this.clickedOn = value;
        this.edit = new JTextField(value.toString());
        edit.addActionListener(this);
        return edit;

    }

    public boolean isCellEditable(EventObject e){
        if(e instanceof MouseEvent){
            if(((MouseEvent)e).getClickCount() == 3){
                return true;
            }
        }
        return false;

    }

    public void actionPerformed(ActionEvent e){
        if(!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());
    }



}
