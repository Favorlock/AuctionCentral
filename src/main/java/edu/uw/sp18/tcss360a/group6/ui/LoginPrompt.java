package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Handle the prompting and validation of logging in users.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class LoginPrompt extends AbstractPrompt {

    public LoginPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();
        List<User> users = application.getUserRepository().fetchAll();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date todaysDate = new Date();
        while (!context.has("user")) {
            console.printf("Welcome to Auction Central " +
                    dateFormat.format(todaysDate) +
                    "\nEnter your user name: \n");
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
