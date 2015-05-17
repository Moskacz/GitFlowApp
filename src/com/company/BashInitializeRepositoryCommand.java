package com.company;


public class BashInitializeRepositoryCommand implements BashCommand {
    private String command;

    public BashInitializeRepositoryCommand() {
        this.command = "git flow init -d";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
