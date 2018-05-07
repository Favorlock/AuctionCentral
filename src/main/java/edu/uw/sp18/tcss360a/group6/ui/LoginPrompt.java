package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

public class LoginPrompt extends AbstractPrompt {

    public LoginPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();
        List<User> users = application.getUserRepository().fetchAll();

        while (!context.has("user")) {
            console.printf("Welcome to Auction Central "+
                    "\nEnter your user name: ");
            String name = console.readLine();

            User user = users.stream()
                    .filter(u -> u.getUserName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                context.set("user", user);
            }
        }

        return true;
    }
}
