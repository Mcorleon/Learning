package com.tqh.memento;

public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(getState());
    }
    public void getStateFromMemento(Memento memento){
        setState(memento.getState());
    }
}
