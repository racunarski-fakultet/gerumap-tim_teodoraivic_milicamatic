package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.GUI;
import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.core.LoggerInterface;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageGenImpl;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.OptionPane;
import raf.dsw.gerumap.repository.command.CommandManager;

public class SwingGui implements GUI, ISubscriber, LoggerInterface {


    public MainFrame mainFrame;
    private CommandManager commandManager;

    public SwingGui(MessageGenImpl messageGen){
        messageGen.addSubs(this);

    }


    @Override
    public void start() {
        mainFrame=MainFrame.getInstance();
        mainFrame.setVisible(true);
        commandManager=new CommandManager();
    }

    @Override
    public void disableUndoAction() {

    }

    @Override
    public void disableRedoAction() {

    }

    @Override
    public void enableUndoAction() {

    }

    @Override
    public void enableRedoAction() {

    }


    @Override
    public void log(Message message) {
        OptionPane optionPane=new OptionPane(message);

    }


    @Override
    public void update(Object notification) {
        log((Message) notification);
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }



}
