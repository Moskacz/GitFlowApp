package com.company;

public class BashFinishHotfix implements BashCommand {
    private String command;

    public BashFinishHotfix(String hotfixName) {
        this.command = "git flow hotfix finish " + hotfixName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
