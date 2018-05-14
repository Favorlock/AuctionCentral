package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import java.util.List;

/**
 * Display a list of all auctions the user has placed bids in.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderAuctionsPrompt extends AbstractPrompt {

	public BidderAuctionsPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting to view bidder's
     * associated auctions.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
        ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();

        Bidder user = context.get("user", Bidder.class);
        List<Auction> auctions = user.getPlacedBidAuctions();
        if(auctions.size() > 0) {
            for(Auction auction : auctions) {
                console.printfln("Auction: %d, Start Date: %tD", auction.getId(), auction.getStartDate());
            }
        } else {
            console.printfln("You have not placed any bids in any "
            		+ "auctions yet...");
        }
        
        
        return true;
    }
    
}
