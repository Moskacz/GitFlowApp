package com.company;

public class BashFinishRelease implements BashCommand{
    private String command;

    public BashFinishRelease(String releaseName) {
        this.command = "git flow release finish " + releaseName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
