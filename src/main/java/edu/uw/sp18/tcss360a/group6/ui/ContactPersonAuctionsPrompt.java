package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/6/2018
 */
public class ContactPersonAuctionsPrompt extends AbstractPrompt {

    public ContactPersonAuctionsPrompt(Context context) {
        super(context);
    }
    
    /**
     * Method used to execute the logic and prompting of view of contact 
     * person's auctions.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
    	boolean isDone = false;
    	ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();
        ContactPerson contact = context.get("user", ContactPerson.class);
        List<Auction> auctions = contact.getOrganization().getAuctions();
        int selection = 0;
        console.printfln("Auctions submitted:");
        for (int i = 0; i < auctions.size(); i++) {
        	console.printfln("%d. " + auctions.get(i).getStartDate(), i+1);
        }


        console.printfln("%d. Main menu.", auctions.size() + 1);
        console.printfln("Enter choice:");
        while (selection == 0) {
        	selection = Integer.parseInt(console.readLine());
        }
        
        if (selection == auctions.size() + 1) {
        	isDone = true;
        }
        else {
            Auction auction = auctions.get(selection - 1);
        	ContactPersonItemsPrompt items = new ContactPersonItemsPrompt
        			(context, auction);
        	items.start();
        }
        return isDone;
    }
    
}
