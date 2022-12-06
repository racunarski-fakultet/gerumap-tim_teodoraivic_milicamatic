package raf.dsw.gerumap.gui.swing.controller;


public class ActionManager {

    private ExitAction exitAction;

    private NewAction newAction;

    private InfoAction infoAction;

    private DeleteAction deleteAction;

    private EditAction editAction;

    private AutorAction autorAction;

    private ConceptAction conceptAction;
    private LinkAction linkAction;
    private MoveAction moveAction;
    private SelectionAction selectionAction;
    private SettingAction settingAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newAction = new NewAction();
        infoAction=new InfoAction();
        deleteAction=new DeleteAction();
        editAction=new EditAction();
        autorAction=new AutorAction();

        conceptAction=new ConceptAction();
        linkAction=new LinkAction();
        moveAction=new MoveAction();
        selectionAction=new SelectionAction();
        settingAction=new SettingAction();
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

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public AutorAction getAutorAction() {
        return autorAction;
    }

    public void setAutorAction(AutorAction autorAction) {
        this.autorAction = autorAction;
    }

    public ConceptAction getConceptAction() {
        return conceptAction;
    }

    public void setConceptAction(ConceptAction conceptAction) {
        this.conceptAction = conceptAction;
    }

    public LinkAction getLinkAction() {
        return linkAction;
    }

    public void setLinkAction(LinkAction linkAction) {
        this.linkAction = linkAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public void setMoveAction(MoveAction moveAction) {
        this.moveAction = moveAction;
    }

    public SelectionAction getSelectionAction() {
        return selectionAction;
    }

    public void setSelectionAction(SelectionAction selectionAction) {
        this.selectionAction = selectionAction;
    }

    public SettingAction getSettingAction() {
        return settingAction;
    }

    public void setSettingAction(SettingAction settingAction) {
        this.settingAction = settingAction;
    }
}
