package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;
import edu.uw.sp18.tcss360a.group6.ui.BidderMenuPrompt;
import edu.uw.sp18.tcss360a.group6.ui.ContactPersonMenuPrompt;
import edu.uw.sp18.tcss360a.group6.ui.LoginPrompt;

/**
 * Run the Auction central interface and perform the necessary business logic.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class ConsoleApplication extends Bootstrap {

    private Console console = new Console();

    private boolean running = true;

    public ConsoleApplication() {
        this(true);
    }

    public ConsoleApplication(boolean saveDefaultsIfMissing) {
        super(saveDefaultsIfMissing);
    }

    public void start() {
        while (this.running) {
            // Context to use through lifetime of a user session
            Context context = new Context();
            // Prompts a user to login and retrieves valid user
            LoginPrompt loginPrompt = new LoginPrompt(context);
            loginPrompt.start();
            // Fetch the user from the context
            User user = context.get("user", User.class);

            this.console.printfln("Hello %s.", user.getUserName());
            // Prompt user with menu options
            if (user.getType() == UserType.BIDDER) {
                BidderMenuPrompt bidderMenuPrompt = new BidderMenuPrompt(context);
                bidderMenuPrompt.start();
            } else if (user.getType() ==  UserType.CONTACT_PERSON) {
                ContactPersonMenuPrompt contactMenuPrompt = new ContactPersonMenuPrompt(context);
                contactMenuPrompt.start();
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public Console getConsole() {
        return console;
    }

    public static void main(String... args) {
        new ConsoleApplication().start();
    }
}