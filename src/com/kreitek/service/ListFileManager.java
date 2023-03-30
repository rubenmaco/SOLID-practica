package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;

import java.util.List;

public class ListFileManager {

    private SingleFileManager singleFileManager;

    public ListFileManager() {
        singleFileManager = new SingleFileManager();
    }




    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {
            if (item instanceof File) {
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                totalSize += calculateSize(item.listFiles());
            }
        }

        return totalSize;
    }

}

