package com.company;

public class BashStartNewRelease implements BashCommand {
    private String command;

    public BashStartNewRelease(String releaseName) {
        this.command = "git flow release start " + releaseName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
