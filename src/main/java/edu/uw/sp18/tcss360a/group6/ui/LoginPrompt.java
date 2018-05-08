package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Handle the prompting and validation of logging in users.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class LoginPrompt extends AbstractPrompt {

    private static final DateTimeFormatter LOGIN_DATE_FORMAT = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");

    private List<User> users;

    public LoginPrompt(Context context) {
        super(context);
        this.users = Application.getInstance().getUserRepository().fetchAll();
    }

    /**
     * Method used to execute the logic and prompting of log in prompt.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        LocalDateTime now = LocalDateTime.now();
        console.printfln("Welcome to Auction Central %s",
                LOGIN_DATE_FORMAT.format(now));
        console.printf("Enter your user name: ");

        String name = console.readLine();
        User user = this.users.stream()
                .filter(u -> u.getUserName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (user != null) {
            context.set("user", user);
        }

        return context.has("user");
    }
}
