package com.ood.state;

public abstract class State {

    public abstract void changeState(StateManager stateManager);
    public abstract Color getColor();
}
