package com.test.eventloop;

import com.test.ICommand;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Worker {

    private BlockingQueue<ICommand> iCommands = new ArrayBlockingQueue<>(1024);

    public void start() {
        Thread thread = new Thread(this::work);
        thread.setName("Separate Test Thread");
        thread.start();
    }


    private void work() {
        for (ICommand command : iCommands) {
            try {
                System.out.println("The Thread name is " + Thread.currentThread().getName());
                System.out.println("Trying to execute :" + command);

                if (command.getClass().getSimpleName().equals("HardStopCommand")) {
                    break;
                }

                command.execute();


            } catch (Exception e) {
                System.out.println("Catch exception: " + e);
            }

        }
    }

    public void add(ICommand iCommand) {
        iCommands.offer(iCommand);
    }

}
