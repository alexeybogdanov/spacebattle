public class Rotate implements ICommand{

    private Rotable rotable;

    public Rotate(Rotable rotable) {
        this.rotable = rotable;
    }

    public void execute() {
        rotable.setDirection(
                (rotable.getDirection() + rotable.getAngularVelocity()) % rotable.getDirectionsNumber());
    }
}
