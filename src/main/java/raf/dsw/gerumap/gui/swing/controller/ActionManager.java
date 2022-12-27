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
    private DeleteElementAction deleteElementAction;

    private UndoAction undoAction;
    private RedoAction redoAction;

    private OpenAction openAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;

    private ExportAction exportAction;

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
        deleteElementAction=new DeleteElementAction();

        undoAction=new UndoAction();
        redoAction=new RedoAction();
        openAction = new OpenAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        exportAction = new ExportAction();
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

    public DeleteElementAction getDeleteElementAction() {
        return deleteElementAction;
    }

    public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
        this.deleteElementAction = deleteElementAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(OpenAction openAction) {
        this.openAction = openAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public void setSaveAsAction(SaveAsAction saveAsAction) {
        this.saveAsAction = saveAsAction;
    }

    public ExportAction getExportAction() {
        return exportAction;
    }

    public void setExportAction(ExportAction exportAction) {
        this.exportAction = exportAction;
    }
}
