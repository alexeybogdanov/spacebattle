public class Move {

    private Movable movable;

    public Move(Movable movable) {
        this.movable = movable;
    }

    public void execute(){
        movable.setPosition(CustomVector.plus(movable.getPosition(), movable.getVelocity()));
    }
}