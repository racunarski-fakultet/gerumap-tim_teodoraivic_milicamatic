package raf.dsw.gerumap.gui.swing.controller;


public class ActionManager {

    private ExitAction exitAction;

    private NewAction newAction;

    private InfoAction infoAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newAction = new NewAction();
        infoAction=new InfoAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }
}
