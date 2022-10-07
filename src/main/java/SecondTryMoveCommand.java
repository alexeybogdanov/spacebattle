public class SecondTryMoveCommand implements ICommand {

    ICommand command;

    public SecondTryMoveCommand(ICommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}
