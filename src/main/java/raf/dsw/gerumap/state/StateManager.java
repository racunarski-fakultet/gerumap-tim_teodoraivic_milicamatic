package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.stanja.ConceptState;
import raf.dsw.gerumap.state.stanja.ConnectionState;
import raf.dsw.gerumap.state.stanja.DeleteState;
import raf.dsw.gerumap.state.stanja.SelectionState;

public class StateManager {

    private State currentState;

    private ConceptState conceptState;

    private ConnectionState connectionState;

    private DeleteState deleteState;

    private SelectionState selectionState;

    public StateManager(){
        initStates();
    }

    private void initStates(){

        conceptState = new ConceptState();
        connectionState = new ConnectionState();
        deleteState = new DeleteState();
        selectionState = new SelectionState();

        currentState = conceptState;
    }

    public State getCurrent(){
        return currentState;
    }

    public void setConceptState(){
        currentState = conceptState;
    }

    public void setConnectionState(){
        currentState = connectionState;
    }

    public void setDeleteState(){
        currentState = deleteState;
    }
}
