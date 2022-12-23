package raf.dsw.gerumap.core;

import raf.dsw.gerumap.repository.command.CommandManager;

public interface GUI {

    void start();

    void disableUndoAction();
    void disableRedoAction();
    void enableUndoAction();
    void enableRedoAction();

    CommandManager getCommandManager();

}
