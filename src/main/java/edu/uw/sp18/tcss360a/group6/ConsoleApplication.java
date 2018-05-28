package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;

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

    public void stop() {
        this.running = false;
    }

    public Console getConsole() {
        return console;
    }

}