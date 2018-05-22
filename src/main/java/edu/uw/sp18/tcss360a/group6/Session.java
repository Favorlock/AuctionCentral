package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.model.User;

public class Session extends Context {

    private static Session instance;

    public static void create(User user) {
        instance = new Session();
        instance.set("user", user);
    }

    public static void clear() {
        instance = null;
    }

    public static Session getInstance() {
        return instance;
    }

    public boolean isSessionActive() {
        return instance != null;
    }
}
