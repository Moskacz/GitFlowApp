package com.company;

public class CommitStringParser {

    public Commit parseString(String str) {
        int startIndex = str.indexOf("(");
        int endIndex = str.indexOf(")");

        if (startIndex != -1 && endIndex != -1) {
            String commitHash = str.substring(0, startIndex);
            String commitBranches = str.substring(startIndex, endIndex + 1);
            String commitName = str.substring(endIndex + 1, str.length());
            return new Commit(commitHash, commitBranches, commitName);
        } else {
            int spaceIndex = str.indexOf(" ");
            String commitHash = str.substring(0, spaceIndex);
            String commitName = str.substring(spaceIndex, str.length());
            return new Commit(commitHash, "", commitName);
        }

    }
}
