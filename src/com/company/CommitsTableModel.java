package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CommitsTableModel extends AbstractTableModel {
    private ArrayList<Commit> commits;

    public CommitsTableModel(ArrayList<Commit> commits) {
        this.commits = commits;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Hash:";
            case 1:
                return "Message:";
            case 2:
                return "Branches:";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return commits.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Commit commit = commits.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return commit.getHashString();
            case 1:
                return commit.getName();
            case 2:
                return commit.getBranches();
            default:
                return null;
        }
    }
}
