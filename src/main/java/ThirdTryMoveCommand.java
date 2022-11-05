package com.test;

public class ThirdTryMoveCommand implements ICommand {

    ICommand command;

    public ThirdTryMoveCommand(ICommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}
