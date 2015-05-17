package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BashExecutor {
    private Process process;

    public BashCommandOutput executeCommands(ArrayList<BashCommand> commands) {
        String compositeCommand = "";
        for (BashCommand cmd: commands) {
            compositeCommand += cmd.getCommand() + ";";
        }
        return executeStringCommand(compositeCommand);
    }

    private BashCommandOutput executeStringCommand(String command) {
        ArrayList<String> errorLines = new ArrayList<String>();
        ArrayList<String> outputLines = new ArrayList<String>();

        try {
            process = Runtime.getRuntime().exec(new String[] {"/bin/sh", "-c", command });

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                errorLines.add(line);
            }
            reader.close();

            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BashCommandOutput(outputLines, errorLines);
    }
}
