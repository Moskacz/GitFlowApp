package com.company;

import java.util.ArrayList;

public class BashCommandOutput {
    private ArrayList<String> output;
    private ArrayList<String> error;

    public BashCommandOutput(ArrayList<String> output, ArrayList<String> error) {
        this.output = output;
        this.error = error;
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    public ArrayList<String> getError() {
        return error;
    }
}
