package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import edu.uw.sp18.tcss360a.group6.model.Item;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

/**
 *	Display Items I have available in my auctions.
 *  View brief overview of items in my auctions.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/4/2018
 */
public class ContactPersonItemsPrompt extends AbstractPrompt {

	private Auction associatedAuction;
    public ContactPersonItemsPrompt(Context context, Auction auction) {
    	super(context);
    	associatedAuction = auction;
        
    }

    @Override
    public boolean execute(Context context) {
    	boolean isDone = false;
    	Application application = Application.getInstance();
        Console console = application.getConsole();


        int selection = 0;
        List<Item> inventory = associatedAuction.getInventory();
        
        console.printfln("Date: %tD", associatedAuction.getStartDate());
        for(int i = 0; i < inventory.size(); i++) {
        	console.printfln("ID: %d, Description: %s, Start Bid: %Bd, Quantity:"
        			+ " %d", 
        			inventory.get(i).getId(), inventory.get(i).getDescription(), 
        			inventory.get(i).getStartBid(), 
        			inventory.get(i).getQuantity());
        }
        
        console.printfln("What would you like to do next?");
        console.printfln("1. Select another auction.");
        console.printfln("2. Back to main menu.");
        
        while (selection == 0) {
        	selection = Integer.parseInt(console.readLine());
        }

        switch (selection) {
            case 1:
            	isDone = true;
            	
                break;
            case 2:
                ContactPersonMenuPrompt menuPrompt = new ContactPersonMenuPrompt(context);
                menuPrompt.start();
                break;

            default:
            	console.printfln("Improper choice.");
                console.printfln("What would you like to do next?");
                console.printfln("1. Select another auction.");
                console.printfln("2. Back to main menu.");
                break;
        }
        return isDone;
    }
    
}
