package com.company;


public class BashListBranches implements BashCommand {
    private String command;

    public BashListBranches() {
        this.command = "git branch";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
