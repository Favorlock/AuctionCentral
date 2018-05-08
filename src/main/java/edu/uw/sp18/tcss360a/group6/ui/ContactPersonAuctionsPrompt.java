package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class ContactPersonAuctionsPrompt extends AbstractPrompt {

    public ContactPersonAuctionsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
    	boolean isDone = false;
    	Application application = Application.getInstance();
        Console console = application.getConsole();
        ContactPerson contact = context.get("user", ContactPerson.class);
        List<Auction> auctions = contact.getOrganization().getAuctions();
        int selection = 0;
        console.printfln("Auctions submitted:");
        for (int i = 0; i < auctions.size(); i++) {
        	console.printfln("%d. " + auctions.get(i).getStartDate(), i+1);
        }
        console.printfln("%d. Main menu.", auctions.size());
        console.printfln("Enter choice:");
        while (selection == 0) {
        	selection = Integer.parseInt(console.readLine());
        }
        
        if (selection == auctions.size()) {
        	isDone = true;
        }
        else {
        	ContactPersonItemsPrompt items = new ContactPersonItemsPrompt(context, auctions.get(selection));
        	items.start();
        }
        return isDone;
    }
    
}
