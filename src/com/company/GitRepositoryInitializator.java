package com.company;

import java.util.ArrayList;

public class GitRepositoryInitializator {
    private BashExecutor executor;

    public GitRepositoryInitializator(BashExecutor executor) {
        this.executor = executor;
    }

    public boolean repositoryExistsAtPath(String absolutePath) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(absolutePath));
        commands.add(new BashRepositoryExistsCheck());
        BashCommandOutput result = executor.executeCommands(commands);
        return result.getError().isEmpty();
    }

    public void initializeRepositoryAtPath(String absolutePath) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(absolutePath));
        commands.add(new BashInitializeRepositoryCommand());
        BashCommandOutput result = executor.executeCommands(commands);
        if (!result.getError().isEmpty()) {
            System.out.println(result.getError());
        }
    }
}
