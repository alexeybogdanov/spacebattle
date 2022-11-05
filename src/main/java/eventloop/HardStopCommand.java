package com.test.eventloop;

import com.test.ICommand;

public class HardStopCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Hard Stop");
    }
}
