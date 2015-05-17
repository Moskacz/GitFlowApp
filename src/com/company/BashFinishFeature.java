package com.company;


public class BashFinishFeature implements BashCommand {
    private String command;

    public BashFinishFeature(String featureName) {
        this.command = "git flow feature finish " + featureName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
