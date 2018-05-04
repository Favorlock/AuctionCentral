package edu.uw.sp18.tcss360a.group6;

public class Application {

    private static Application instance;

    public static void main(String... args) {
        instance = new Application();
    }

    public static Application getInstance() {
        return instance;
    }
}
