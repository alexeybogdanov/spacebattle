import java.util.List;

public class MoveMacroCommand implements ICommand{

    private List<ICommand> commands;

    public MoveMacroCommand(List<ICommand> commands) {
        this.commands = commands;
    }


    @Override
    public void execute() {
        if (!commands.isEmpty()) {
            commands.forEach(ICommand::execute);
        }
    }
}
