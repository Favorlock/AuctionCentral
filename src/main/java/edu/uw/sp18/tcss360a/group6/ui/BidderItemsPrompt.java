package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

import static edu.uw.sp18.tcss360a.group6.model.UserType.BIDDER;

/**
 * Display all of the items that a user has bid on.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderItemsPrompt extends AbstractPrompt {

	private String line;
    public BidderItemsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();
        User user = application.getUser();
        if (user.getType() == BIDDER) {
            Bidder bidder = (Bidder) user;
            List<Bid> bids = bidder.getPlacedBids();
            for(Bid b : bids) {
                console.printf(b.toString());
            }
        }

        //then do option to quit
        
        return true;
    }
    
}
