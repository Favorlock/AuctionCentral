package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.User;
import edu.uw.sp18.tcss360a.group6.model.UserType;

import java.util.List;

/**
 * Display all of the items that a user has bid on.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderItemsPrompt extends AbstractPrompt {

	public BidderItemsPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting of bidder's item prompt.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        User user = context.get("user", User.class);
        if (user.getType() == UserType.BIDDER) {
            Bidder bidder = (Bidder) user;
            List<Bid> bids = bidder.getPlacedBids();
            if(bids.size() > 0) {
                for(Bid bid : bids) {
                    console.printf(bid.toString());
                }
            } else {
                console.printfln("You have not placed any bids on items yet....");
            }
        }

        return true;
    }
    
}
