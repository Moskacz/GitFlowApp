package com.company;

public class BashRepositoryExistsCheck implements BashCommand {
    private String command;

    public BashRepositoryExistsCheck() {
        this.command = "git rev-parse";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
