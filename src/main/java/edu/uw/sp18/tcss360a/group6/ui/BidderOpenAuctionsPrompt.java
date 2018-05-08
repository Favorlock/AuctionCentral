package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bidder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Display to the caller all of the auctions that have Items the user can bid
 * on.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderOpenAuctionsPrompt extends AbstractPrompt {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^([+-]?[0-9]\\d*|0)$");

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
    	boolean completed = false;
        Application application = Application.getInstance();
        Console console = application.getConsole();
        Bidder bidder = context.get("user", Bidder.class);

        List<Auction> auctions = Application.getInstance()
        		.getAuctionRepository().fetchAll().stream()
                .filter(auction -> bidder.canBid(auction))
                .collect(Collectors.toList());
        int i = 1;
        console.printfln("Auctions you can bid in: ");
        for(Auction auction : auctions) {
            console.printfln("%d. Auction: %d, Start Date: %tD", i++, auction.getId(), auction.getStartDate());
        }

        int lastAuctionOption = i - 1;
        int mainMenuOption = i++;
        console.printfln("%d. Main Menu.", mainMenuOption);
        console.printfln("Choose an option.");


        String selection = console.readLine();
        Matcher matcher = INTEGER_PATTERN.matcher(selection);
        if (matcher.matches()) {
            int option = Integer.parseInt(selection);
            if (option > 0 && option <= i - 1) {
                if (option <= lastAuctionOption) {
                    Auction auction = auctions.get(option - 1);
                    Context nextContext = new Context(context, "user");
                    nextContext.set("auction", auction);
                    BidderListBiddableItemsPrompt bidderListBiddableItemsPrompt = new BidderListBiddableItemsPrompt(nextContext);
                    bidderListBiddableItemsPrompt.start();
                }

                completed = true;
            }
        }

        return completed;
    }
    
}
