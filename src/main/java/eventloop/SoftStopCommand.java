package com.test.eventloop;

import com.test.ICommand;

public class SoftStopCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Soft Stop");
    }
}
