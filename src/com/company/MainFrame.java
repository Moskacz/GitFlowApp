package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private BashExecutor bashExecutor;
    private GitRepositoryInitializator respositoryInitializator;
    private GitRepositoryManager repositoryManager;
    private MainPanel mainPanel;

    public MainFrame() {
        setTitle("GitFlow");
        setSize(new Dimension(800,400));
        setResizable(false);

        bashExecutor = new BashExecutor();
        respositoryInitializator = new GitRepositoryInitializator(bashExecutor);
        repositoryManager = new GitRepositoryManager(bashExecutor, "/Users/michalmoskala/Documents/Git training/part3");

        setupMenuBar();
        setupMainPanel();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu repositoryMenu = new JMenu("Repository");
        JMenuItem setPathItem = new JMenuItem("Set path");
        setPathItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDirectoryChooser();
            }
        });
        repositoryMenu.add(setPathItem);
        menuBar.add(repositoryMenu);

        JMenu featuresMenu = new JMenu("Features");
        JMenuItem startFeatureItem = new JMenuItem("Start new feature");
        startFeatureItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askUserForFeatureName();
            }
        });
        featuresMenu.add(startFeatureItem);
        JMenuItem finishFeatureItem = new JMenuItem("Finish feature");
        finishFeatureItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmFeatureFinish();
            }
        });
        featuresMenu.add(finishFeatureItem);
        menuBar.add(featuresMenu);

        JMenu releasesMenu = new JMenu("Releases");
        JMenuItem startReleaseItem = new JMenuItem("Start new release");
        startReleaseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askUserForReleaseName();
            }
        });
        releasesMenu.add(startReleaseItem);
        JMenuItem finishReleaseItem = new JMenuItem("Finish release");
        finishReleaseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmReleaseFinish();
            }
        });
        releasesMenu.add(finishReleaseItem);
        menuBar.add(releasesMenu);

        JMenu hotfixesMenu = new JMenu("Hotfixes");
        JMenuItem startHotfixItem = new JMenuItem("Start hotfix");
        startHotfixItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForHotfixStart();
            }
        });
        hotfixesMenu.add(startHotfixItem);
        JMenuItem finishHotfixItem = new JMenuItem("Finish hotfix");
        finishHotfixItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForHotfixEnd();
            }
        });
        hotfixesMenu.add(finishHotfixItem);
        menuBar.add(hotfixesMenu);

        JMenu commitMenu = new JMenu("Commit");
        JMenuItem commitChangesItem = new JMenuItem("Commit changes");
        commitChangesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askUserForCommitMessage();
            }
        });
        commitMenu.add(commitChangesItem);
        menuBar.add(commitMenu);

        JMenu authorsMenu = new JMenu("Authors");
        JMenuItem showAuthorsItem = new JMenuItem("Show authors");
        showAuthorsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAuthorsPanel();
            }
        });
        authorsMenu.add(showAuthorsItem);
        menuBar.add(authorsMenu);
    }

    private void openDirectoryChooser() {
        JFileChooser dictChooser = new JFileChooser();
        dictChooser.setFileFilter(new FolderFilter());
        dictChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = dictChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String absolutePath = dictChooser.getSelectedFile().getAbsolutePath();
            if (respositoryInitializator.repositoryExistsAtPath(absolutePath)) {

            } else {
                askIfUserWantsToInitializeRepoAtPath(absolutePath);
            }
        }
    }

    private void askIfUserWantsToInitializeRepoAtPath(String path) {
        int input = JOptionPane.showOptionDialog(null, "Do you want to create repository?", "Repository missing", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (input == JOptionPane.OK_OPTION) {
            respositoryInitializator.initializeRepositoryAtPath(path);
        }
    }

    private void setupMainPanel() {
        mainPanel = new MainPanel("/Users/michalmoskala/Documents/Git training/part3", bashExecutor);
        getContentPane().add(mainPanel);
    }

    private void askUserForCommitMessage() {
        String message = showInputPanel("Commit", "Enter commit message:");
        if (message != null && !message.isEmpty()) {
            repositoryManager.commitChangesWithMessage(message);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void askUserForFeatureName() {
        String featureName = showInputPanel("New feature", "Enter feature name:");
        if (featureName != null && !featureName.isEmpty()) {
            repositoryManager.startNewFeature(featureName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void confirmFeatureFinish() {
        String featureName = showInputPanel("Feature finish", "Enter feature name that you want to finish");
        if (featureName != null && !featureName.isEmpty()) {
            repositoryManager.finishFeature(featureName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void askUserForReleaseName() {
        String releaseName = showInputPanel("New release", "Enter release name:");
        if (releaseName != null && !releaseName.isEmpty()) {
            repositoryManager.startNewRelease(releaseName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void confirmReleaseFinish() {
        String releaseName = showInputPanel("Finish release", "Enter release name that you want to finish");
        if (releaseName != null && !releaseName.isEmpty()) {
            repositoryManager.finishRelease(releaseName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void askForHotfixStart() {
        String hotfixName = showInputPanel("New hotfix", "Enter name for new hotfix: ");
        if (hotfixName != null && !hotfixName.isEmpty()) {
            repositoryManager.startNewHotfix(hotfixName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private void askForHotfixEnd() {
        String hotfixName = showInputPanel("Finish hotfix", "Enter hotfix name that you want to finish");
        if (hotfixName != null && !hotfixName.isEmpty()) {
            repositoryManager.finishHotfix(hotfixName);
            mainPanel.refreshRepositoryStatus();
        }
    }

    private String showInputPanel(String title, String message) {
        return JOptionPane.showInputDialog(this, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    private void showAuthorsPanel() {
        JOptionPane.showMessageDialog(this, "Michał Moskała,\nMichał Jakóbski\nKonfiguracje i Rewizje Oprogramowania\nAGH EAIIB\nInformatyka V rok", "Authors", JOptionPane.INFORMATION_MESSAGE);
    }
}
