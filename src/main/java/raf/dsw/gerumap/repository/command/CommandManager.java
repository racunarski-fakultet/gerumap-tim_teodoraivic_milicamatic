package raf.dsw.gerumap.repository.command;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand>commandList=new ArrayList<>();

    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while(currentCommand < commandList.size())
            commandList.remove(currentCommand);
        commandList.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commandList.size()){
            commandList.get(currentCommand++).doCommand();

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
            AppCore.getInstance().getGui().enableUndoAction();
        }
        if(currentCommand==commandList.size()){
            AppCore.getInstance().getGui().disableRedoAction();
        }
    }


    public void undoCommand(){
        if(currentCommand > 0){
            AppCore.getInstance().getGui().enableRedoAction();
            commandList.get(--currentCommand).undoCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
        }
        if(currentCommand==0){
            AppCore.getInstance().getGui().disableUndoAction();
        }
    }




}
