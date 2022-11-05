package com.test.eventloop;

import com.test.ICommand;

public class StartCommand implements ICommand {

    @Override
    public void execute() {
        Worker worker = new Worker();
        worker.start();
    }

}
