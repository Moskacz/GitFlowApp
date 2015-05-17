package com.company;


public class BashListCommits implements BashCommand {
    private String command;

    public BashListCommits() {
        this.command = "git log --decorate --oneline";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
