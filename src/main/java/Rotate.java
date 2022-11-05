package com.test;

public class Rotate  implements ICommand{

    private Rotable rotable;

    public Rotate(Rotable rotable) {
        this.rotable = rotable;
    }

    @Override
    public void execute() {
        rotable.setDirection(
                (rotable.getDirection() + rotable.getAngularVelocity()) % rotable.getDirectionsNumber());
    }
}
