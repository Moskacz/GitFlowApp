package com.company;

public class BashStartNewHotfix implements BashCommand {
    private String command;

    public BashStartNewHotfix(String hotfixName) {
        this.command = "git flow hotfix start " + hotfixName;
    }

    @Override
    public String getCommand() {
        return command;
    }
}
