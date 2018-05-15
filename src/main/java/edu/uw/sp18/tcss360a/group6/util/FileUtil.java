package edu.uw.sp18.tcss360a.group6.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void saveJson(File destination, String json) {
        try {
            if (destination.getParentFile() != null) {
                destination.getParentFile().mkdirs();
            }

            if (!destination.exists()) {
                destination.createNewFile();
            }

            try (FileWriter fw = new FileWriter(destination)) {
                fw.write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
