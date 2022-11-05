package com.test;


public class Log implements ICommand {

    ICommand command;
    Exception e;

    public Log(ICommand command, Exception e) {
        this.command = command;
        this.e = e;
    }

    @Override
    public void execute() {
        System.out.println(String.format("Log: try to call {%s} ends with {%s}", command.getClass().getSimpleName(), e.getMessage()));
    }
}
