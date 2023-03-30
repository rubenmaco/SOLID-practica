package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;

public class SingleFileManager {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemItem item : fileSystemItem.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }


    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
