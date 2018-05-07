package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

public class BidderMenuPrompt extends AbstractPrompt {

	private String line;
    public BidderMenuPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
    	boolean completed = false;
        Application application = Application.getInstance();
        Console console = application.getConsole();
        line = null;
        
        console.printf("Choose an option\n");
        console.printf("1. View brief overview of all auctions I have placed bids in.\n");
        console.printf("2. View all items I have bid on in all auctions.\n");
        console.printf("3. View in brief all auctions I can bid on.\n");
        console.printf("4. Logout.\n");

        while (line == null) {
        	line = console.readLine();
        }
        Context theContext = new Context();
        switch (line.toLowerCase()) {
        
        case "1":
        	BidderAuctionsPrompt auctions = new BidderAuctionsPrompt(theContext);
        	auctions.start();
        	break;
        case "2":
        	BidderItemsPrompt bidderItems = new BidderItemsPrompt(theContext);
        	break;
        case "3":
        	BidderOpenAuctionsPrompt openAuctions = new BidderOpenAuctionsPrompt(theContext);
        	break;
        case "4":
        	completed = true;
        	break;
        }
        
        
        return completed;
    }
    
}
