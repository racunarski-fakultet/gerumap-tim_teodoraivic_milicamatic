package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.stanja.*;

public class StateManager {

    private State currentState;

    private ConceptState conceptState;

    private ConnectionState connectionState;

    private DeleteState deleteState;

    private MoveState moveState;

    private SelectionState selectionState;

    public StateManager(){
        initStates();
    }

    private void initStates(){

        conceptState = new ConceptState();
        connectionState = new ConnectionState();
        deleteState = new DeleteState();
        selectionState = new SelectionState();
        moveState=new MoveState();

        currentState = connectionState;
    }
    public State getCurrent(){
        return currentState;
    }

    public void setConceptState() { currentState = conceptState; }

    public void setConnectionState(){
        currentState = connectionState;
    }

    public void setDeleteState(){
        currentState = deleteState;
    }

    public void setMoveState() {
        currentState = moveState;
    }

    public void setSelectionState() {
        currentState = selectionState;
    }
}
