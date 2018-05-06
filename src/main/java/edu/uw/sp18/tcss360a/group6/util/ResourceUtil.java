package edu.uw.sp18.tcss360a.group6.util;

import java.io.*;

public class ResourceUtil {

    public static boolean saveResource(
            String resource,
            File destination,
            boolean overwrite) {
        boolean result = false;

        if (overwrite && destination.exists()) {
            destination.delete();
        }

        if (!destination.exists()) {
            result = saveResource(resource, destination);
        }

        return result;
    }

    private static boolean saveResource(String resource, File destination) {
        boolean result = false;

        try (InputStream in = ResourceUtil.class.getClassLoader()
                .getResourceAsStream(resource)) {
            try (OutputStream out = new FileOutputStream(destination)) {
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                out.write(buffer);
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
