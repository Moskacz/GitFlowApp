package com.company;

public class Commit {
    private String hashString;
    private String branches;
    private String name;

    public Commit(String hashString, String branches, String name) {
        this.hashString = hashString;
        this.branches = branches;
        this.name = name;
    }

    public String getHashString() {
        return hashString;
    }

    public String getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }
}
