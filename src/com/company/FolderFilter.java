package com.company;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class FolderFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Directories only";
    }
}
