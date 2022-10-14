public class Move implements ICommand{

    private Movable movable;

    public Move() {
    }

    public Move(Movable movable) {
        this.movable = movable;
    }

    public void execute(){
        movable.setPosition(CustomVector.plus(movable.getPosition(), movable.getVelocity()));
    }
}
