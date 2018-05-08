package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

/**
 * Display to the caller all of the auctions that have Items the user can bid
 * on.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderOpenAuctionsPrompt extends AbstractPrompt {

	private String line;
    public BidderOpenAuctionsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        console.printfln("Auctions you can bid in: ");


        
        return true;
    }
    
}
