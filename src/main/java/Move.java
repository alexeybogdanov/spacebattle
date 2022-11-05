package com.test;

public class Move implements ICommand {

    private Movable movable;

    public Move(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute(){
        movable.setPosition(CustomVector.plus(movable.getPosition(), movable.getVelocity()));
    }
}
