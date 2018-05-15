package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;

/**
 * Prompt the User with a valid list of selectable options.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderMenuPrompt extends AbstractPrompt {

    public BidderMenuPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting of the main bidder 
     * menu prompt.
     * 
     * @boolean used to represent whether the prompt should return to 
     * previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
        ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();

        boolean completed = false;
        String line = null;

        console.printfln("Choose an option");
        console.printfln("1. View brief overview of all auctions I have "
        		+ "placed bids in.");
        console.printfln("2. View all items I have bid on in all "
        		+ "auctions.");
        console.printfln("3. View in brief all auctions I can bid on.");
        console.printfln("4. Logout.");
        console.printfln("5. Quit.");

        while (line == null) {
            line = console.readLine();
        }

        switch (line.toLowerCase()) {
            case "1":
                BidderAuctionsPrompt auctions = 
                new BidderAuctionsPrompt(context);
                auctions.start();
                break;
            case "2":
                BidderItemsPrompt bidderItems = 
                new BidderItemsPrompt(context);
                bidderItems.start();
                break;
            case "3":
                BidderOpenAuctionsPrompt openAuctions = 
                new BidderOpenAuctionsPrompt(context);
                openAuctions.start();
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