package com.company;

public class BashCommit implements BashCommand {
    private String command;

    public BashCommit(String commitMessage) {
        this.command = "git commit -m " + commitMessage;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
