package com.company;

public class BashChangeDirectoryCommand implements BashCommand {
    private String command;

    public BashChangeDirectoryCommand(String absolutePath) {
        this.command = "cd " + pathWithinQuotes(absolutePath);
    }

    private String pathWithinQuotes(String path) {
        return "\"" + path + "\"";
    }

    @Override
    public String getCommand() {
        return command;
    }
}
