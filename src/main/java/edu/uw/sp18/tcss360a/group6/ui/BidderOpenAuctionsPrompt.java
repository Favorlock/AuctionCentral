package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Display to the caller all of the auctions that have Items the user can bid
 * on.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderOpenAuctionsPrompt extends AbstractPrompt {

	public BidderOpenAuctionsPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting of bidder's open auctions
     *  they can bid on.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
    	int selection = 0;
    	boolean canBack = false;
        Application application = Application.getInstance();
        Console console = application.getConsole();

        List<Auction> allAuctions = Application.getInstance()
        		.getAuctionRepository().fetchAll().stream()
                .filter(auction -> auction.isAcceptingBids())
                .collect(Collectors.toList());
        int i = 0;
        console.printfln("Auctions you can bid in: ");
        for(Auction auction : allAuctions) {
            if(auction.isAcceptingBids()) {
            	i++;
                console.printfln("%d. Auction: %d, Start Date: %tD", i, auction.getId(), auction.getStartDate());
                
            }
            
        }
        console.printfln("%d. Main Menu.", i+1);
        console.printfln("Choose an option.");

        i--;
        while (selection == 0) {
        	selection = Integer.parseInt(console.readLine());
        }
        
        if (selection == i + 1) {
        	canBack = true;
        }
        else {
            // TODO
//        	BidderAddItemPrompt add = new BidderAddItemPrompt(context);
//
//        	add.start();
        }
        
        return canBack;
    }
    
}
