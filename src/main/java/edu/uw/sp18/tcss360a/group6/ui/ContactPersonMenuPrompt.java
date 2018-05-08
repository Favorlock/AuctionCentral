package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;

/**
 * Prompt the User with a valid list of selectable options.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/3/2018
 */
public class ContactPersonMenuPrompt extends AbstractPrompt {

    public ContactPersonMenuPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        boolean completed = false;
        String line = null;

        console.printfln("Choose an option");
        console.printfln("1. View brief overview of items in my auctions.");
        console.printfln("2. Submit auction request.");
        console.printfln("3. Add inventory for auction.");
        console.printfln("4. Logout.");
        console.printfln("5. Quit.");

        while (line == null) {
            line = console.readLine();
        }

        switch (line.toLowerCase()) {

            case "1":
                ContactPersonAuctionsPrompt items = new ContactPersonAuctionsPrompt(context);
                items.start();
                break;
            case "2":
                AuctionRequestPrompt request = new AuctionRequestPrompt(context);
                request.start();
                break;
            case "3":
                AddInventoryPrompt add = new AddInventoryPrompt(context);
                add.start();
                break;
            case "4":
                completed = true;
                break;
            case "5":
                completed = true;
                application.stop();
                break;
            default:
                break;
        }


        return completed;
    }

}