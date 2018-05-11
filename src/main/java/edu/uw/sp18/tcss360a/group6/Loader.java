package edu.uw.sp18.tcss360a.group6;

/**
 * Loads the application main after setting required properties.
 */
public class Loader {

    public static void main(String... args) throws Exception {
        System.setProperty("prism.order", "sw");
        Main.main(args);
    }

}
