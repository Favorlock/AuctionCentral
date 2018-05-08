package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.AuctionRepository;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Submit a new auction to be added to the AuctionRepository.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AuctionRequestPrompt extends AbstractPrompt {

	private String line;
    public AuctionRequestPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();
        // can add an auction
        // get input to add a new auction
        // create new auction object and add to auction repository

        long auctionID;
        long organizationID;
        LocalDate startDate;

        console.printfln("Enter the auction ID: "); //should be done dynamic
        auctionID = Long.parseLong(console.readLine());

        console.printfln("Enter organization ID: ");
        organizationID = Long.parseLong(console.readLine());

        console.printfln("Enter the auction date in the format: 2007-12-03 ");
        startDate = LocalDate.parse(console.readLine());

        Auction anAuction = new Auction(auctionID, organizationID, startDate);

        AuctionRepository.add(anAuction);

        //
        /*
        Pattern r = Pattern.compile("^\d{2}/\d{2}/\d{4}$");

        String date = "05/07/2018";
        date.matches("^\d{2}/\d{2}/\d{4}$");
         */
        
        return true;
    }
    
}
