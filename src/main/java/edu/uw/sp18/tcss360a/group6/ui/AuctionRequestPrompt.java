package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;

import java.time.LocalDate;

/**
 * Submit a new auction to be added to the AuctionRepository.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AuctionRequestPrompt extends AbstractPrompt {
	
	public AuctionRequestPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting of auction request prompt.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
        ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();
        // can add an auction (check here or elsewhere)
        // get input to add a new auction
        // create new auction object and add to auction repository

        ContactPerson contact = context.get("user", ContactPerson.class);
        Auction auction;

        if (contact.getOrganization().getCurrentAuction() != null) {
            console.printfln("Your organization has already scheduled an Auction.");
        } else if ((auction = contact.getOrganization().getAuctionWithinLastYear()) != null) {
            console.printfln("You must wait a full year to schedule another auction.");
            console.printfln("Last auction scheduled on %s", auction.getStartDate());
        } else {
            LocalDate startDate;

            console.printfln("Enter the auction date in the format: 2007-12-03 ");
            startDate = LocalDate.parse(console.readLine());

            auction = new Auction(contact.getOrganizationId(), startDate);

            //add the auction to the repository
            contact.getOrganization().addAuction(auction);

        /*
        Pattern r = Pattern.compile("^\d{2}/\d{2}/\d{4}$");

        String date = "05/07/2018";
        date.matches("^\d{2}/\d{2}/\d{4}$");
         */

        }

        return true;
    }
    
}
