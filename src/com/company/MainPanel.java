package com.company;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private GitRepositoryStatus repositoryStatus;
    private JLabel currentBranchLabel;
    private JTable commitsTable;

    public MainPanel(String repositoryAbsolutePath, BashExecutor bashExecutor) {
        this.repositoryStatus = new GitRepositoryStatus(repositoryAbsolutePath, bashExecutor);
        setupUpperPanel();
        setupLowerPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setupUpperPanel() {
        JPanel upperPanel = new JPanel();
        add(upperPanel);

        currentBranchLabel = new JLabel("Current branch: " + repositoryStatus.getCurrentBranchName());
        upperPanel.add(currentBranchLabel);
    }

    private void setupLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1,1));
        add(lowerPanel);

        commitsTable = new JTable(new CommitsTableModel(repositoryStatus.getCommits()));
        JScrollPane scrollPanel = new JScrollPane(commitsTable);
        lowerPanel.add(scrollPanel);
    }

    public void refreshRepositoryStatus() {
        currentBranchLabel.setText("Current branch: " + repositoryStatus.getCurrentBranchName() );
        commitsTable.setModel(new CommitsTableModel(repositoryStatus.getCommits()));
    }
}
