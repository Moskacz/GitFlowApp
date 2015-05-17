package com.company;

public class BashAddFilesToRepository implements BashCommand {
    private String command;

    public BashAddFilesToRepository() {
        this.command = "git add -A";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
