package com.company;

import java.util.ArrayList;

public class GitRepositoryManager {
    private BashExecutor bashExecutor;
    private String repositoryAbsolutePath;

    public GitRepositoryManager(BashExecutor bashExecutor, String repositoryAbsolutePath) {
        this.bashExecutor = bashExecutor;
        this.repositoryAbsolutePath = repositoryAbsolutePath;
    }

    public void commitChangesWithMessage(String message) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashAddFilesToRepository());
        commands.add(new BashCommit(message));
        bashExecutor.executeCommands(commands);
    }

    public void startNewFeature(String featureName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashStartNewFeature(featureName));
        bashExecutor.executeCommands(commands);
    }

    public void finishFeature(String featureName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashFinishFeature(featureName));
        bashExecutor.executeCommands(commands);
    }

    public void startNewRelease(String releaseName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashStartNewRelease(releaseName));
        bashExecutor.executeCommands(commands);
    }

    public void finishRelease(String releaseName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashFinishRelease(releaseName));
        bashExecutor.executeCommands(commands);
    }

    public void startNewHotfix(String hotfixName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashStartNewHotfix(hotfixName));
        bashExecutor.executeCommands(commands);
    }

    public void finishHotfix(String hotfixName) {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repositoryAbsolutePath));
        commands.add(new BashFinishHotfix(hotfixName));
        bashExecutor.executeCommands(commands);
    }
}
