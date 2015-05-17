package com.company;

import java.util.ArrayList;

public class GitRepositoryStatus {
    private String repoAbsolutePath;
    private BashExecutor executor;

    public GitRepositoryStatus(String repoAbsolutePath, BashExecutor executor) {
        this.repoAbsolutePath = repoAbsolutePath;
        this.executor = executor;
    }

    public String getCurrentBranchName() {
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repoAbsolutePath));
        commands.add(new BashListBranches());
        BashCommandOutput commandsResult = executor.executeCommands(commands);
        ArrayList<String> branches = commandsResult.getOutput();

        for (String branchName: branches) {
            if (branchName.contains("*")) {
                return branchName;
            }
        }
        return null;
    }

    public ArrayList<Commit> getCommits() {
        CommitStringParser parser = new CommitStringParser();
        ArrayList<BashCommand> commands = new ArrayList<BashCommand>();
        commands.add(new BashChangeDirectoryCommand(repoAbsolutePath));
        commands.add(new BashListCommits());
        ArrayList<String> stringCommits = executor.executeCommands(commands).getOutput();
        ArrayList<Commit> commits = new ArrayList<Commit>();

        for (String commit: stringCommits) {
            commits.add(parser.parseString(commit));
        }
        return commits;
    }

}
