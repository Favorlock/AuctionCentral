package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

/**
 * Display a list of all auctions the user has placed bids in.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderAuctionsPrompt extends AbstractPrompt {

	private String line;
    public BidderAuctionsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        Bidder user = context.get("user", Bidder.class);
        List<Bid> bids = user.getPlacedBids();
        
        for(Bid aBid : bids) {
            console.printfln(aBid.toString());
        }
        
        
        return true;
    }
    
}
