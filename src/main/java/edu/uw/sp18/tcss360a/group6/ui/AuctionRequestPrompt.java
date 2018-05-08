package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
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

        // public Auction(long id, long organizationId, LocalDate startDate)
        long auctionID;
        long organizationID;
        LocalDate startDate;



        //
        /*
        Pattern r = Pattern.compile("^\d{2}/\d{2}/\d{4}$");

        String date = "05/07/2018";
        date.matches("^\d{2}/\d{2}/\d{4}$");
         */
        
        return true;
    }
    
}
