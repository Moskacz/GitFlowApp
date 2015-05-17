package com.company;

public class BashStartNewFeature implements BashCommand {
    private String command;

    public BashStartNewFeature(String featureName) {
        this.command = "git flow feature start " + featureName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
